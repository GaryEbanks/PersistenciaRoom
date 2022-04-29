package com.example.persistenciaroom.fragments.lista

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.persistenciaroom.database.entities.UsuariosEntity
import com.example.persistenciaroom.databinding.ListaUsuarioBinding

class UsuarioAdapter :
    RecyclerView.Adapter<UsuarioAdapter.UsuarioHolder>() {
        private var listadoUsuario = emptyList<UsuariosEntity>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UsuarioHolder {
        val binding =  ListaUsuarioBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UsuarioHolder(binding)

    }

    override fun onBindViewHolder(holder: UsuarioHolder, position: Int) {
        holder.bind(
            listadoUsuario[position]
        )
    }

    override fun getItemCount(): Int = listadoUsuario.size

    fun setData(users: List<UsuariosEntity>){
        this.listadoUsuario = users
        notifyDataSetChanged()
    }

    inner class UsuarioHolder(val binding: ListaUsuarioBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(usuario: UsuariosEntity) {
            with(binding){
                TvIdUsuario.text = usuario.idUsuario.toString()
                TvUserName.text = usuario.nombreUsuario
                TvNombres.text = usuario.nombres
                TvApellidos.text = usuario.apellidos

                ClFila.setOnClickListener {
                    val action = ListaFragmentDirections.listaActualizar(usuario)
                    it.findNavController().navigate(action)
                }
            }
        }
    }

}
package com.example.persistenciaroom.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.persistenciaroom.database.entities.UsuariosEntity

@Dao
interface UsuariosDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert (usuario: UsuariosEntity)

    @Query("SELECT * FROM TblUsuarios")
    suspend fun getAll(): List<UsuariosEntity>

    @Query("SELECT * FROM TblUsuarios")
    fun getAllRealData(): LiveData<List<UsuariosEntity>>

    @Update
    suspend fun update(usuarios: UsuariosEntity)

    @Delete
    suspend fun delete(usuario: UsuariosEntity)

    @Query("DELETE FROM TblUsuarios")
    suspend fun deleteAll()

}
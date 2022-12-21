package br.com.alura.agenda.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import br.com.alura.agenda.database.converter.ConversorCalendar;
import br.com.alura.agenda.database.converter.CoversorTipoTelefone;
import br.com.alura.agenda.database.dao.AlunoDAO;
import br.com.alura.agenda.database.dao.TelefoneDAO;
import br.com.alura.agenda.model.Aluno;
import br.com.alura.agenda.model.Telefone;

@Database(entities = {Aluno.class, Telefone.class}, version = 6, exportSchema = false)
@TypeConverters({ConversorCalendar.class, CoversorTipoTelefone.class})
public abstract class AgendaDatabase extends RoomDatabase {

    public static final String DATABASE_NAME = "agenda.db";

    public abstract AlunoDAO getRoomAlunoDAO();

    public abstract TelefoneDAO getTelfoneDAO();

    public static AgendaDatabase getInstance(Context context){
        return Room.databaseBuilder(context,
                        AgendaDatabase.class, DATABASE_NAME)
                .addMigrations(AgendaMigrations.TODAS_MIGRATIONS)
                .build();
    }
}

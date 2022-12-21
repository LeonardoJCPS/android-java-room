package br.com.alura.agenda.database.converter;

import androidx.room.TypeConverter;

import br.com.alura.agenda.model.TipoTelefone;

public class CoversorTipoTelefone {

    @TypeConverter
    public String toString(TipoTelefone tipoTelefone) {
        return tipoTelefone.name();
    }

    @TypeConverter
    public TipoTelefone toTipoTelefone(String valor) {
        if (valor != null) {
            return TipoTelefone.valueOf(valor);
        }
        return TipoTelefone.FIXO;
    }
}

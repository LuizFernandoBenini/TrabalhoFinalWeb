package mycompany.trabalhoweb.converter;

import mycompany.trabalhoweb.dao.TipoQuestaoDAO;
import mycompany.trabalhoweb.model.Tbtipoquestao;
import java.io.Serializable;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


@FacesConverter(forClass = Tbtipoquestao.class, value = "tipoQuestaoConverter")
public class TipoQuestaoConverter implements Converter, Serializable {
    private static final long serialVersionUID = 1L;

    @Override
    public Object getAsObject(FacesContext arg0, UIComponent arg1, String id) {
        if (id != null && !id.isEmpty()) {
            return TipoQuestaoDAO.getInstance().buscarPorId(Long.valueOf(id));
        }
        return id;
    }

    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, Object objeto) {
        if (objeto != null) {
            Tbtipoquestao tipoQuestao = (Tbtipoquestao) objeto;
            return tipoQuestao.getIdTipoQuestao() != null && tipoQuestao.getIdTipoQuestao() > 0 ? tipoQuestao.getIdTipoQuestao().toString() : null;
        }
        return null;
    }
}
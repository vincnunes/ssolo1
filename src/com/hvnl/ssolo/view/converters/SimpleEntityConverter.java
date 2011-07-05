/*
 * 09/07/2009
 */
package com.hvnl.ssolo.view.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import com.hvnl.ssolo.model.Model;

/**
 * Conversor JSF para qualquer tipo de {@link Model}.
 * @author heber
 */
public class SimpleEntityConverter implements Converter {

    /**
     * Transforma a representação String de um {@link Model} em objeto do tipo
     * {@link Model}.
     * @param ctx contexto JSF
     * @param component componente
     * @param value valor
     * @return um {@link Model}
     */
    public Object getAsObject(FacesContext ctx, UIComponent component, String value) {
        if (value != null) {
            Object selected = component.getAttributes().get(value);
            return selected;
        }
        return null;
    }

    /**
     * Transforma um {@link Model} em uma String. {@link Model}.
     * @param ctx contexto JSF
     * @param component componente
     * @param value valor
     * @return representação String de um {@link Model}
     */
    public String getAsString(FacesContext ctx, UIComponent component, Object value) {
        if (value instanceof Model) {
            Model entidade = (Model) value;
            Long codigo = entidade.getId();
            if (codigo != null) {
                String valueOf = String.valueOf(codigo);
                component.getAttributes().put(valueOf, value);
                return valueOf;
            }
        }
        return (String) value;
    }
}

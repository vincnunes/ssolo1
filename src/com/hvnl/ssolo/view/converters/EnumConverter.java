/*
 * 09/07/2010
 */
package com.hvnl.ssolo.view.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

/**
 * Conversor para Enums.
 * @author heber
 */
public class EnumConverter implements Converter {

    /**
     * {@inheritDoc}
     */
	@SuppressWarnings({ "rawtypes", "unchecked" })
    public Object getAsObject(FacesContext context, UIComponent comp, String value)
        throws ConverterException {

		Class type = comp.getValueExpression("value").getType(context.getELContext());
        try {
            return Enum.valueOf(type, value);
        } catch (IllegalArgumentException e) {
            return null;
        } catch (NullPointerException e) {
            return null;
        }
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("rawtypes")
	public String getAsString(FacesContext context, UIComponent component, Object object)
        throws ConverterException {

        if (object == null) {
            return null;
        }

        if (object instanceof String) {
            return (String) object;
        }

        //ADD localization ability
        Enum type = (Enum) object;
        return type.name();
    }
}

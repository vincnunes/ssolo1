/*
 * 04/12/2009
 */
package com.hvnl.ssolo.view.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

import com.hvnl.ssolo.util.CurrencyHelper;


/**
 * Conversor para BigDecimal onde mostrará o número em uma máscara moeda.
 * @author heber
 */
public class CurrencyConverter implements Converter {

    /** {@inheritDoc} */
    public Object getAsObject(FacesContext context, UIComponent component, String value)
        throws ConverterException {

        return CurrencyHelper.getDecimal(value);
    }

    /** {@inheritDoc} */
    public String getAsString(FacesContext context, UIComponent component, Object value)
        throws ConverterException {

        return CurrencyHelper.getCurrencyFormat(value);
    }

}

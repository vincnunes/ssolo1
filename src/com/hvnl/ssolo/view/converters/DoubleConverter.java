/*
 * 28/05/2010
 */
package com.hvnl.ssolo.view.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

import com.hvnl.ssolo.util.CurrencyHelper;


/**
 * Conversor para Double onde mostrará o número em formato brasileiro.
 * @author heber
 *
 */
public class DoubleConverter implements Converter {

    /** {@inheritDoc} */
    public Object getAsObject(FacesContext context, UIComponent component, String value)
        throws ConverterException {

        return CurrencyHelper.getDecimal(value).doubleValue();
    }

    /** {@inheritDoc} */
    public String getAsString(FacesContext context, UIComponent component, Object value)
        throws ConverterException {

        return CurrencyHelper.getDecimalFormat(value);
    }

}

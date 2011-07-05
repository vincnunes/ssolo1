/*
 * 14/08/2009
 */
package com.hvnl.ssolo.view.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 * Permite a passagem apenas de números.
 * @author heber
 */
public class OnlyNumbersConverter implements Converter {

    /** {@inheritDoc} */
    public Object getAsObject(FacesContext ctx, UIComponent component, String value) {
        return getOnlyNumbers(value);
    }

    /** {@inheritDoc} */
    public String getAsString(FacesContext ctx, UIComponent component, Object value) {
        return getOnlyNumbers(String.valueOf(value));
    }

    /**
     * Retira qualquer character que não seja número (digit).
     * @param value texto que será avaliado
     * @return String com números ou vazia
     */
    private String getOnlyNumbers(String value) {
        char [] cs = value.toCharArray();

        String result = "";

        for (char c : cs) {
            if (Character.isDigit(c)) {
                result += String.valueOf(c);
            }
        }

        return result;
    }

}

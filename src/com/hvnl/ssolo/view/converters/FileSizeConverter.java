/*
 * 01/02/2011
 */
package com.hvnl.ssolo.view.converters;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 * Converter para tamanhos de arquivos. Serve apenas para mostrar.
 * @author heber
 */
public class FileSizeConverter implements Converter {

    /**
     * Tamanho em Kilobytes.
     */
    private static final Long KILO = 1024L;
    /**
     * Tamanho em Megabytes.
     */
    private static final Long MEGA = 1024L * KILO;
    /**
     * Tamanho em Gigabytes.
     */
    private static final Long GIGA = 1024L * MEGA;

    /**
     * Formatador.
     */
    private static final DecimalFormat FORMATTER =
        new DecimalFormat("###,###,##0.00",
            new DecimalFormatSymbols(new Locale("pt", "BR")));;

    /** {@inheritDoc} */
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return null;
    }

    /** {@inheritDoc} */
    public String getAsString(FacesContext context, UIComponent component, Object value) {

        if (value instanceof Number) {
            long size = ((Number) value).longValue();

            if (size >= GIGA) {
                return FORMATTER.format(size / GIGA) + " Gb";
            }

            if (size >= MEGA) {
                return FORMATTER.format(size / MEGA) + " Mb";
            }

            if (size >= KILO) {
                return FORMATTER.format(size / KILO) + " Kb";
            }

            return FORMATTER.format(size) + " b";
        }

        return "-";
    }

}

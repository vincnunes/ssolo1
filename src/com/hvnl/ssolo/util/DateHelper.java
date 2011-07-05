/*
 * 28/05/2010
 */
package com.hvnl.ssolo.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Classe de utilidades para datas.
 * @author heber
 */
public final class DateHelper {

    /**
     * Um dia em milisegundos.
     */
    public static final Long DIA = 24 * 60 * 60 * 1000L;

    /**
     * Construtor privado.
     */
    private DateHelper() { }

    /**
     * Calcula a diferença de dias entre duas datas.
     * @param inicio data inicial
     * @param fim data final
     * @return diferença em dias
     */
    public static Long getDiferenca(Date inicio, Date fim) {
        Date a = zerarData(inicio);
        Date b = zerarData(fim);

        long diferenca = b.getTime() - a.getTime();

        return (diferenca / 1000 / 60 / 60 / 24) + 1;
    }

    /**
     * Zera o horário de uma data, ou seja, transforma em dd/MM/yy 00:00:00.
     * @param data que será modificada
     * @return data zerada
     */
    public static Date zerarData(Date data) {
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return format.parse(format.format(data));
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * Soma dias à data.
     * @param data que será somada
     * @param dias que serão somados à data
     * @return data + dias
     */
    public static Date somaDias(Date data, Long dias) {
        return new Date(data.getTime() + (dias * DIA));
    }

    /**
     * Verifica se a data está entre o intervalo de datas, retornando ela, se estiver
     * entre, a data inicial caso a data seja menor que a inicial ou a data final caso
     * seja maior que a final.
     * @param inicio início do período
     * @param fim final do período
     * @param value que será verificada
     * @return uma data válida dentro período
     */
    public static Date getDataEntreIntervalo(Date inicio, Date fim, Date value) {
        if (inicio == null || fim == null || value == null) {
            return null;
        }

        Date i = zerarData(inicio);
        Date f = zerarData(fim);
        Date v = zerarData(value);

        if (i.getTime() > v.getTime()) {
            return i;
        }

        if (v.getTime() > f.getTime()) {
            return f;
        }

        return v;
    }
}

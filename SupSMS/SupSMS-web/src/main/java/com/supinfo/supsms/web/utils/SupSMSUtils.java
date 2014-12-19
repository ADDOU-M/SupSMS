/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supsms.web.utils;

import java.util.Date;


/**
 *
 * @author Ekue_Weledji
 */
public class SupSMSUtils {

    private static final long MILISECOND_PER_DAY = 24 * 60 * 60 * 1000;

    /**
     * Calcul le nombre de jours N entre deux dates
     *
     * @param startDate Date de début
     * @param endDate Date de fin
     * @return Retourne 0 si les deux dates sont identiques, -N si endDate <
     * startDate et +N si endDate > startDate
     */
    public static long daysBetweenTwoDates(Date startDate, Date endDate) {
        return (long) Math.floor((endDate.getTime() - startDate.getTime()) / MILISECOND_PER_DAY);
    }

}

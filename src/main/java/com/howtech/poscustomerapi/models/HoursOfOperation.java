package com.howtech.poscustomerapi.models;

import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Damond Howard
 * @apiNote this is a model that represents the regular store hours of a store
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HoursOfOperation {
    @Id
    @GeneratedValue
    private Long id;
    private LocalTime mondayOpen;
    private LocalTime tuesdayOpen;
    private LocalTime wednesdayOpen;
    private LocalTime thursdayOpen;
    private LocalTime fridayOpen;
    private LocalTime saturdayOpen;
    private LocalTime sundayOpen;
    private LocalTime mondayClose;
    private LocalTime tuesdayClose;
    private LocalTime wednesdayClose;
    private LocalTime thursdayClose;
    private LocalTime fridayClose;
    private LocalTime saturdayClose;
    private LocalTime sundayClose;
    private boolean openForNewYearsEve;
    private LocalTime newYearsEvenOpen;
    private LocalTime newYearsEveClose;
    private boolean openForNewYears;
    private LocalTime newYearsOpen;
    private LocalTime newYearsClose;
    private boolean openForIndependenceDay;
    private LocalTime independenceOpen;
    private LocalTime independenceClose;
    private boolean openForMemorialDay;
    private LocalTime memorialDayOpen;
    private LocalTime memorialDayClose;
    private boolean openForEaster;
    private LocalTime easterOpen;
    private LocalTime easterClose;
    private boolean openForColumbusDay;
    private LocalTime columbusDayOpen;
    private LocalTime columbusDayClose;
    private boolean penForThanksgiving;
    private LocalTime thanksgivingOpen;
    private LocalTime thanksgivingClose;
    private boolean openForChristmasEve;
    private LocalTime christmasEveOpen;
    private LocalTime christmasEveClose;
    private boolean openForChristmas;
    private LocalTime christmasOpen;
    private LocalTime christmasClose;
    private StoreDto store;

    public HoursOfOperation(LocalTime mondayOpen, LocalTime tuesdayOpen, LocalTime wednesdayOpen,
            LocalTime thursdayOpen, LocalTime fridayOpen, LocalTime saturdayOpen, LocalTime sundayOpen,
            LocalTime mondayClose, LocalTime tuesdayClose, LocalTime wednesdayClose, LocalTime thursdayClose,
            LocalTime fridayClose, LocalTime saturdayClose, LocalTime sundayClose, boolean openForNewYearsEve,
            LocalTime newYearsEvenOpen, LocalTime newYearsEveClose, boolean openForNewYears, LocalTime newYearsOpen,
            LocalTime newYearsClose, boolean openForIndependenceDay, LocalTime independenceOpen,
            LocalTime independenceClose, boolean openForMemorialDay, LocalTime memorialDayOpen,
            LocalTime memorialDayClose, boolean openForEaster, LocalTime easterOpen, LocalTime easterClose,
            boolean openForColumbusDay, LocalTime columbusDayOpen, LocalTime columbusDayClose,
            boolean penForThanksgiving, LocalTime thanksgivingOpen, LocalTime thanksgivingClose,
            boolean openForChristmasEve, LocalTime christmasEveOpen, LocalTime christmasEveClose,
            boolean openForChristmas, LocalTime christmasOpen, LocalTime christmasClose, StoreDto store) {
        super();
        this.mondayOpen = mondayOpen;
        this.tuesdayOpen = tuesdayOpen;
        this.wednesdayOpen = wednesdayOpen;
        this.thursdayOpen = thursdayOpen;
        this.fridayOpen = fridayOpen;
        this.saturdayOpen = saturdayOpen;
        this.sundayOpen = sundayOpen;
        this.mondayClose = mondayClose;
        this.tuesdayClose = tuesdayClose;
        this.wednesdayClose = wednesdayClose;
        this.thursdayClose = thursdayClose;
        this.fridayClose = fridayClose;
        this.saturdayClose = saturdayClose;
        this.sundayClose = sundayClose;
        this.openForNewYearsEve = openForNewYearsEve;
        this.newYearsEvenOpen = newYearsEvenOpen;
        this.newYearsEveClose = newYearsEveClose;
        this.openForNewYears = openForNewYears;
        this.newYearsOpen = newYearsOpen;
        this.newYearsClose = newYearsClose;
        this.openForIndependenceDay = openForIndependenceDay;
        this.independenceOpen = independenceOpen;
        this.independenceClose = independenceClose;
        this.openForMemorialDay = openForMemorialDay;
        this.memorialDayOpen = memorialDayOpen;
        this.memorialDayClose = memorialDayClose;
        this.openForEaster = openForEaster;
        this.easterOpen = easterOpen;
        this.easterClose = easterClose;
        this.openForColumbusDay = openForColumbusDay;
        this.columbusDayOpen = columbusDayOpen;
        this.columbusDayClose = columbusDayClose;
        this.penForThanksgiving = penForThanksgiving;
        this.thanksgivingOpen = thanksgivingOpen;
        this.thanksgivingClose = thanksgivingClose;
        this.openForChristmasEve = openForChristmasEve;
        this.christmasEveOpen = christmasEveOpen;
        this.christmasEveClose = christmasEveClose;
        this.openForChristmas = openForChristmas;
        this.christmasOpen = christmasOpen;
        this.christmasClose = christmasClose;
        this.store = store;
    }
}
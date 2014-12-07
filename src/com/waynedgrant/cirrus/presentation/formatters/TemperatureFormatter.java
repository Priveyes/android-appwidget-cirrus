/* Copyright 2014 Wayne D Grant (www.waynedgrant.com)
   Licensed under the MIT License */

package com.waynedgrant.cirrus.presentation.formatters;

import static com.waynedgrant.cirrus.units.TemperatureUnit.CELSIUS;

import java.math.RoundingMode;
import java.util.Locale;

import com.waynedgrant.cirrus.measures.Temperature;
import com.waynedgrant.cirrus.units.TemperatureUnit;

public class TemperatureFormatter
{
    private Temperature temperature;
    
    public TemperatureFormatter(Temperature temperature)
    {
        this.temperature = temperature;
    }

    public String format(TemperatureUnit unit)
    {
        String formatted = null;
        
        if (temperature != null)
        {
            String formatString = null;
            
            if (unit == CELSIUS)
            {
                formatString = "%1.1f°C";
            }
            else
            {
                formatString = "%1.1f°F";
            }
            
            formatted = String.format(Locale.US, formatString, temperature.getValue(unit).setScale(1, RoundingMode.HALF_DOWN));
        }
        else
        {
            if (unit == CELSIUS)
            {
                formatted = "--.-°C";
            }
            else
            {
                formatted = "--.-°F";
            }
        }
        
        return formatted;
    }
}

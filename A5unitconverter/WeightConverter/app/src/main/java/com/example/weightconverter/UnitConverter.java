package com.example.weightconverter;

public class UnitConverter {
    static class Weight {
        public double MilligramToKilogram(double milli) {return (milli/1000000);}

        public double KilogramToMilligram(double Kilo) {return (Kilo*1000000);}

        public double GramToKilogram(double Gram) {return (Gram/1000);}

        public double KilogramToGram(double Kilo) {return (Kilo*1000);}

        public double CentigramToKilogram(double Centi) {return (Centi/100000); }

        public double KilogramToCentigram(double Kilo) {return (Kilo*100000);}

        public double DecigramToKilogram(double Deci) {return (Deci/10000);}

        public double KilogramToDecigram(double Kilo) {return (Kilo*10000);}

        public double MetricTonnesToKilogram(double MetricTonnes) {return (MetricTonnes*1000);}

        public double KilogramToMetricTonnes(double Kilo) {return (Kilo/1000);}

        public double PoundsToKilogram(double Pounds) {return (Pounds/2.20462);}

        public double KilogramToPounds(double Kilo) {return (Kilo*2.20462);}

        public double OuncesToKilogram(double Ounces) {return (Ounces/35.274);}

        public double KilogramToOunces(double Kilo) {return (Kilo*35.274);}
    }

}

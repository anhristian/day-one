package edu.cnm.deepdive;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class TemperatureConversion {

  private static final double FAHRENHEIT_TO_CELCIUS_SCALE = 5.0 / 9.0;
  private static final double CELCIUS_TO_FAHRENHEIT_SCALE = 9.0 / 5.0;
  private static final double SCALE_OFFSET = 32;

  public static void main(String[] args) {
    if (args.length == 0) {
      double tempCelsius = 100;
      double tempFahrenheit = 32;
      System.out.println("Celsius " + tempCelsius + " = " + convertC2F(tempCelsius) + " Fahreheit");
      System.out.println("Fahreheit " + tempFahrenheit + " = " + convertF2C(tempFahrenheit) + " Celsius");
    } else {

      for (int i = 0; i < args.length; i++) {
        double tempCelsius = Double.parseDouble(args[i]);
        System.out.println("Celsius " + tempCelsius + " = " + convertC2F(tempCelsius) + " Fahreheit");
      }

    }
  }

  public static double convertC2F(double celsius) {
    return celsius * CELCIUS_TO_FAHRENHEIT_SCALE + SCALE_OFFSET;

  }
  public static double convertF2C(double fahrenheit) {
    return (fahrenheit - SCALE_OFFSET) * FAHRENHEIT_TO_CELCIUS_SCALE;

  }
  public static double[] convertC2F(double[] celsiusTemperatures) {
    double[] fahrenheitTemperatures = new double[celsiusTemperatures.length];
    for (int i = 0; i < celsiusTemperatures.length; i++) {
      double celsius = celsiusTemperatures[i];
      double fahrenheit = convertC2F(celsius);
      fahrenheitTemperatures[i] = fahrenheit;
    }
    return fahrenheitTemperatures;
  }

  public static double[] convertF2C(double[] fahrenheitTemperature) {
    double[] celsiusTemperatures = new double[fahrenheitTemperature.length];
    for (int i = 0; i < fahrenheitTemperature.length; i++) {
      double fahrenheit = fahrenheitTemperature[i];
      double celsius = convertF2C(fahrenheit);
      celsiusTemperatures[i] = celsius;
    }
    return celsiusTemperatures;
  }

 public static void convertInputToFahrenheit(InputStream input, PrintStream output) {
    Scanner scanner = new Scanner(input);
    while (true) {
      double celsius = scanner.nextDouble();
      double fahrenheit = convertC2F(celsius);
      output.println(fahrenheit);
    }
 }
}






package com.example.equation2nddegree;

// EquationSolver.java
public class EquationSolver {
    public static String solveEquation(double a, double b, double c) {
        // Calculer le discriminant
        double discriminant = b * b - 4 * a * c;

        // Calculer les solutions
        double root1, root2;
        if (discriminant > 0) {
            root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            return "Deux solutions réelles : " + root1 + " et " + root2;
        } else if (discriminant == 0) {
            root1 = -b / (2 * a);
            return "Une solution réelle : " + root1;
        } else {
            return "Pas de solution réelle, discriminant négatif.";
        }
    }
}

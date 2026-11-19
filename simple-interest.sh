#!/bin/bash
# Skrypt obliczający odsetki proste
echo "Podaj kwotę kapitału:"
read p
echo "Podaj roczną stopę procentową:"
read r
echo "Podaj okres w latach:"
read t

# Obliczenie odsetek prostych: (P * R * T) / 100
si=$(echo "scale=2; ($p * $r * $t) / 100" | bc)
echo "Odsetki proste wynoszą: $si"
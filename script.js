// Funkcja pomocnicza do bezpiecznej konwersji na liczbę
function convertToNumber(value) {
    // Sprawdzenie, czy wartość istnieje i nie jest pusta
    if (value === null || value === undefined || value === "") {
        return 0; // lub rzuć błąd, w zależności od wymagań
    }
    
    // Konwersja na liczbę
    const num = Number(value);
    
    // Sprawdzenie, czy konwersja się powiodła
    if (isNaN(num)) {
        throw new TypeError("Wartość nie jest prawidłową liczbą: " + value);
    }
    
    return num;
}

// Przykładowa funkcja, która mogłaby powodować błąd TypeError
function calculateTotal(price, quantity) {
    const p = convertToNumber(price);
    const q = convertToNumber(quantity);
    return p * q;
}

// Eksport dla Node.js (jeśli jest wymagany)
if (typeof module !== 'undefined' && module.exports) {
    module.exports = { convertToNumber, calculateTotal };
}

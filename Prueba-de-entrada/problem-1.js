/*
    Irene tiene n monedas en su cartera, las monedas pueden tener diferentes valores,
    pero ella puede tener más de una moneda del mismo valor. Ella quiere dar todas sus
    monedas a sus dos hijos, de manera que la diferencia de lo que reciban sea mínima,
    de esa manera cualquiera de ellos estará triste. Escriba un programa que encuentre
    cuánto dinero recibe cada niño.
*/

const moneyArr = [
    [1, 2],
    [2, 4],
    [5, 2]
];
const targetSum = sum(moneyArr)/2;
console.log("Suma objetivo de un niño: " + targetSum);


const kidArr = [
    [1, 0],
    [2, 0],
    [5, 0]
];
for (let i = 0; i < kidArr.length; i++) {
    kidArr[i][1] = moneyArr[i][1]/2;
}
const kidSum = sum(kidArr);
console.log("Suma de uno de los niños: " + kidSum);


function sum(arr) {
    let sum = 0;
    for (const coin of arr) {
        sum += coin[0] * coin[1];
    }
    return sum;
}
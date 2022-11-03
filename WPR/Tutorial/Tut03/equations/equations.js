function linearEquation(a, b) {
    if (a === 0 & b === 0) {
        return ("The equation has infinitely many solutions!");
    } else if (a === 0) {
        return ("The equation has no solution!");
    } else {
        return ("The equation has one solution: x = " + (-b / a));
    }
}

function quadraticEquation(a, b, c) {
    if (a === 0 && b === 0 && c === 0) {
        return ("These numbers are not correct!");
    } else if (a == 0 && b == 0) {
        return ("The equation has no root!");
    } else if (a == 0) {
        return ("There is one root: " + (-c / b));
    } else {
        if ((b * b - 4 * a * c) < 0) {
            return ("The equation has no real root!");
        } else {
            return ("There are two root:\nx1 = " + ((-b + Math.sqrt(b * b - 4 * a * c)) / 2 / a) + ", x2 = " + ((-b - Math.sqrt(b * b - 4 * a * c)) / 2 / a));
        }
    }
}
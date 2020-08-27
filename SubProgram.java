package ru.epam.jonline.module2.sub_program;

import static java.lang.Math.*;

public class SubProgram {

//	Написать метод для нахождения наибольшего общего делителя и наименьшего общего кратного двух
//	натуральных чисел

	public static void firstTask(int a, int b) {
		System.out.printf("%nAnswer firstTask (бинарный алгоритм Евклида): %n");
		System.out.printf("A = %d, B = %d %n", a, b);

		int nod;

		nod = (a % 2 == 0 && b % 2 == 0) ? (2 * findNOD(a / 2, b / 2))
				: (a % 2 != 0 && b % 2 == 0) ? (findNOD(a, b / 2))
						: (a % 2 != 0 && b % 2 != 0 && a > b) ? (findNOD(a - b, b)) : (a == b) ? a : (findNOD(a, b));

		System.out.println("НОД (бинарный алгоритм Евклида): " + nod);
		System.out.println("НОК (бинарный алгоритм Евклида): " + (a * b) / nod);
	}

	
//	Написать метод для нахождения наибольшего общего делителя четырех натуральных чисел
	
	public static void secondTask(int a, int b, int c, int d) {
		System.out.printf("%nAnswer secondTask: %n");
		
		int nod;
		
		nod  = findNOD(findNOD(a, b), findNOD(c, d));
		
		System.out.printf("A = %d, B = %d, C = %d, D = %d%n", a, b, c, d);
		System.out.println("НОД (бинарный алгоритм Евклида): " + nod);
	}
	
	
//	Вычислить площадь правильного шестиугольника со стороной а, используя метод вычисления площади треугольника

	public static void thirdTask(int a) {
		System.out.printf("%nAnswer thirdTask: %n");
		
		System.out.printf("Площадь шестиугольника со стороной %d равна %.4f: %n", a, 6 * areaRegularTriangle(a));
		System.out.printf("Площадь шестиугольника со стороной %d равна %.4f: %n", a, 6 * areaTriangle(a, a, a));
	}
	
	
//	На плоскости заданы своими координатами n точек. 
//	Написать метод(методы), определяющие, между какими из пар точек самое большое расстояние. 
//	Указание. Координаты точек занести в массив

	public static void fourthTask(int[] arr) {
		System.out.printf("%nAnswer fourthTask: %n");
		System.out.println("Дан массив точек [x1, y1 ... xN, yN]");
		printIntArray(arr);
		
		double dist;
		double max = 0;
		
		for (int i = 0; i < arr.length - 3; i += 2) {
			for (int j = i; j < arr.length - 3; j += 2) {
				dist = distanceBetweenPoints(arr[j], arr[j + 1], arr[j + 2], arr[j + 3]);
				max = (dist > max) ? dist : max;
			}
		}
		
		System.out.printf("Max расстояние равно: %.4f %n", max);
	}
	
	
//	Составить программу, которая в массиве A[N] находит второе по величине число 
//	(вывести на печать число, которое меньше максимального элемента массива, но больше всех других элементов)

	public static void fifthTask(int[] arr) {
		System.out.printf("%nAnswer fifthTask: %n");
		printIntArray(arr);
		
		int max = arr[0];
		int max1 = 0;
		
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max) {
				max1 = max;
				max = arr[i];
			}
		}
		
		System.out.println("Второе по величине число равно: " + max1);
	}
	
	
//	Написать метод, проверяющий, являются ли данные три числа взаимно простыми

	public static void sixthTask(int a, int b, int c) {
		System.out.printf("%nAnswer sixthTask: %n");
		System.out.printf("a=%d, b=%d, c=%d %n", a, b, c);
		
		if (findNOD(a, b) == 1 && findNOD(b, c) == 1 && findNOD(a, c) == 1) {
			System.out.println("Числа взаимно простые");
		} else {
			System.out.println("Числа не являются взаимно простыми");
		}
	}
	
	
//	Написать метод для вычисления суммы факториалов всех нечетных чисел от 1 до 9

	public static void seventhTask() {
		System.out.printf("%nAnswer seventhTask: %n");

		for (int i = 1; i <= 9; i += 2) {
			System.out.printf("Факториал числа %d равен %d %n", i, factorial(i));
		}
	}
	
	
//	Задан массив D. Определить следующие суммы: D[l] + D[2] + D[3]; D[3] + D[4] + D[5]; D[4] +D[5] +D[6].
//	Пояснение. Составить метод(методы) для вычисления суммы трех последовательно расположенных элементов массива с номерами от k до m

	public static void eighthTask(double[] arr) {
		System.out.printf("%nAnswer eighthTask: %n");
		printDoubleArray(arr);

		System.out.printf("Сумма трех элементов начиная с %d равна %.2f %n", 1, sumThreeElemsArray(arr, 1));
		System.out.printf("Сумма трех элементов начиная с %d равна %.2f %n", 3, sumThreeElemsArray(arr, 3));
		System.out.printf("Сумма трех элементов начиная с %d равна %.2f %n", 4, sumThreeElemsArray(arr, 4));
	}
	
	
//	Даны числа X, Y, Z, Т — длины сторон четырехугольника. 
//	Написать метод вычисления его площади, если угол между сторонами длиной X и Y— прямой

	public static void ninthTask(double x, double y, double z, double t) {
		System.out.printf("%nAnswer ninthTask: %n");
		System.out.println("Длины сторон четырехугольника: " + x + y + z + t);
		
		double g = sqrt(pow(x, 2) + pow(y, 2));
		double s = areaTriangle(x, y, g) + areaTriangle(z, t, g);
		
		System.out.println("Площадь четырехугольника: " + s);
	}
	
	
//	Дано натуральное число N. Написать метод для формирования массива, элементами которого являются цифры числа N

	public static void tenthTask(int n) {
		System.out.printf("%nAnswer tenthTask: %n");
		System.out.println("Массив, элементами которого являются цифры числа " + n);
		
		int[] arr = numberToArray(n);
		
		printIntArray(arr);
	}
	
//	Написать метод(методы), определяющий, в каком из данных двух чисел больше цифр

	public static void eleventhTask(int a, int b) {
		System.out.printf("%nAnswer eleventhTask: %n");
		System.out.println(a + " " + b);

		if (countDigits(a) > countDigits(b)) {
			System.out.println("В первом числе больше цифр ");
		} else {
			if (countDigits(a) < countDigits(b)) {
				System.out.println("Во втором числе больше цифр ");
			} else {
				System.out.println("Количество цифр в числах равно");
			}
		}
	}
	
	
//	Даны натуральные числа К и N. 
//	Написать метод формирования массива А, элементами которого являются числа, сумма цифр которых равна К и которые не большее N

	public static void twelfthTask(int k, int n) {
		System.out.printf("%nAnswer twelfthTask: %n");

		int[] arrTemp = new int[n / 5];
		int j = 0;
		
		for (int i = 0; i < n; i++) {
			if (sumDigitsInNumber(i) == k) {
				arrTemp[j] = i;
				j++;
			}
		}
		
		int[] arr = new int[j];
		
		for (int i = 0; i < j; i++) {
			arr[i] = arrTemp[i];
		}
		
		printIntArray(arr);
	}
	
	
//	Два простых числа называются «близнецами», если они отличаются друг от друга на 2 (например, 41 и 43). 
//	Найти и напечатать все пары «близнецов» из отрезка [n,2n], где n - заданное натуральное число больше 2. 
//	Для решения задачи использовать декомпозицию

	public static void thirteenthTask(int n) {
		System.out.printf("%nAnswer thirteenthTask: %n");

		int temp = 0;
		
		for (int i = n; i < 2 * n; i++) {
			if (checkSimpleNumber(i)) {
				if (i - temp == 2) {
					System.out.print(temp + " " + i + " ");
				}
				temp = i;
			}
		}
	}
	
	
//	Натуральное число, в записи которого n цифр, называется числом Армстронга, 
//	если сумма его цифр, возведенная в степень n, равна самому числу. 
//	Найти все числа Армстронга от 1 до k. Для решения задачи использовать декомпозицию

	public static void fourteenthTask(int k) {
		System.out.printf("%nAnswer fourteenthTask: %n");
		
		for (int i = 10; i < k; i++) {
			if (i == pow(sumDigitsInNumber(i), countDigits(i))) {
				System.out.print(i + " ");
			}
		}
	}
	
	
//	Найти все натуральные n-значные числа, цифры в которых образуют строго возрастающую последовательность (например, 1234, 5789). 
//	Для решения задачи использовать декомпозицию

	public static void fifteenthTask(int n) {
		System.out.printf("%nAnswer fifteenthTask: %n");

		int k = (int) (pow(10, n) - 1);
		int t = (int) (pow(10, n - 1));
		
		for (int i = t; i < k; i++) {
			boolean check = true;
			int[] arr = numberToArray(i);
			for (int j = 0; j < countDigits(i) - 1; j++) {
				if (arr[j] + 1 != arr[j + 1]) {
					check = false;
					break;
				}
			}
			if (check) {
				System.out.println(i);
			}
		}
	}
	
	
//	Написать программу, определяющую сумму n - значных чисел, содержащих только нечетные цифры. 
//	Определить также, сколько четных цифр в найденной сумме. Для решения задачи использовать декомпозицию

	public static void sixteenthTask(int n) {
		System.out.printf("%nAnswer sixteenthTask: %n");

		int k = (int) (pow(10, n) - 1);
		int t = (int) (pow(10, n - 1));
		
		for (int i = t; i < k; i++) {
			int sum;
			int count = countEvenDigitsInNumber(i);
			if (count == 0) {
				sum = sumDigitsInNumber(i);
				System.out.printf("Сумма цифр в числе %d равна %d %n", i, sum);
				System.out.printf("В ней %d четных цифр %n", (countEvenDigitsInNumber(sum)));
			}
		}
	}
	
	
//	Из заданного числа вычли сумму его цифр. Из результата вновь вычли сумму его цифр и т.д. 
//	Сколько таких действий надо произвести, чтобы получился нуль? Для решения задачи использовать декомпозицию

	public static void seventeenthTask(int n) {
		System.out.printf("%nAnswer seventeenthTask: %n");

		int i = 0;
		
		while (n > 0) {
			n -= sumDigitsInNumber(n);
			i++;
		}
		
		System.out.println(i);
	}

	/*----------------------------*/

	private static int findNOD(int a, int b) {
		
		int nod = a > b ? a : b;
		int min = a < b ? a : b;

		while (nod - min != 0) {
			nod = nod - min;
			if (nod < min) {
				int t = nod;
				nod = min;
				min = t;
			}
		}
		
		return nod;
	}

	private static double areaRegularTriangle(int a) {
		return pow(a, 2) * sqrt(3) / 4;
	}

	private static double distanceBetweenPoints(int x1, int y1, int x2, int y2) {
		return sqrt(pow((x1 - x2), 2) + pow((y1 - y2), 2));
	}

	private static int factorial(int num) {
		
		int result = 1;
		
		for (int i = 1; i <= num; i++) {
			result = result * i;
		}
		
		return result;
	}

	private static double sumThreeElemsArray(double[] arr, int startElem) {
		
		double sum = 0;
		
		for (int i = startElem; i < startElem + 3; i++) {
			sum += arr[i];
		}
		
		return sum;
	}

	private static double areaTriangle(double a, double b, double c) {
		
		double p = (a + b + c) / 2;
		
		return sqrt(p * (p - a) * (p - b) * (p - c));
	}

	private static int countDigits(int n) {
		
		int k = 1;
		
		while (n / 10 != 0) {
			n = n / 10;
			k++;
		}
		
		return k;
	}

	private static int[] numberToArray(int n) {
		
		int k = countDigits(n);
		int d = (int) pow(10, k - 1);
		int[] arr = new int[k];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (n / d) % 10;
			d = d / 10;
		}
		
		return arr;
	}

	private static int sumDigitsInNumber(int n) {
		
		int sum = 0;
		
		for (int dig : numberToArray(n)) {
			sum += dig;
		}
		
		return sum;
	}

	private static boolean checkSimpleNumber(int n) {
		
		for (int i = 2; i < n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		
		return true;
	}

	private static int countEvenDigitsInNumber(int n) {
		
		int count = 0;
		int[] arr = numberToArray(n);
		
		for (int j = 0; j < countDigits(n); j++) {
			if (arr[j] % 2 == 0) {
				count++;
			}
		}
		
		return count;
	}

	static void printIntArray(int[] arr) {
		for (int elem : arr) {
			System.out.print(elem + " ");
		}
		System.out.println();
	}

	static void printDoubleArray(double[] arr) {
		for (double elem : arr) {
			System.out.print(elem + " ");
		}
		System.out.println();
	}
}

package dev.utils;

public class TestStringUtils {

	public static void main(String[] args) throws Exception {

		// Test avec différentes valeurs non-nulles
		if (StringUtils.levenshteinDistance("chat", "chats") != 1) {

			throw new Exception("levenshteinDistance devrait retourner 1");

		} else {

			System.out.println("Test 1 OK");

		}

		if (StringUtils.levenshteinDistance("chat", "chat") != 0) {

			throw new Exception("levenshteinDistance devrait retourner 0");

		} else {

			System.out.println("Test 2 OK");

		}

		if (StringUtils.levenshteinDistance("chat", "") != 4) {

			throw new Exception("levenshteinDistance devrait retourner 4");

		} else {

			System.out.println("Test 3 OK");

		}

		// Test de la méthode avec des arguments null
		if (StringUtils.levenshteinDistance(null, null) != 2) {

			throw new Exception("levenshteinDistance doit avoir des arguments non - nulls");

		} else {

			System.out.println("Test 4 OK");

		}

	}

}

package dev.utils;

import org.junit.Test;

import junit.framework.Assert;

public class StringUtilsTest {

	@Test
	public void testLevenshteinDistanceWithNormalStringParameters() {
		
		int resultat = StringUtils.levenshteinDistance("chat", "chats");
		Assert.assertEquals(1, resultat);
		
	}
	
	@Test
	public void testLevenshteinDistanceWithSameArgumentTwice() {
		
		int resultat = StringUtils.levenshteinDistance("chat", "chat");
		Assert.assertEquals(0, resultat);
		
	}
	
	@Test
	public void testLevenshteinDistanceWithEmptyString() {
		
		int resultat = StringUtils.levenshteinDistance("chat", "");
		Assert.assertEquals(4, resultat);
		
	}
	
	@Test
	public void testLevenshteinDistanceWithCapitalCharacter() {
		
		int resultat = StringUtils.levenshteinDistance("chat", "Chat");
		Assert.assertEquals(1, resultat);
		
	}

	@Test(expected = NullPointerException.class)
	public void testLevenshteinDistanceWithTwoNullArgument() {
		
		StringUtils.levenshteinDistance(null, null);
		
	}
	
	@Test(expected = NullPointerException.class)
	public void testLevenshteinDistanceWithOneNullArgument() {
		
		StringUtils.levenshteinDistance("chat", null);
		
	}

}

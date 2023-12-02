package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TestDemoJUnitTest {

	private TestDemo testDemo;

	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}

	private static Stream<Arguments> argumentsForAddPositive() {
		return Stream.of(
				Arguments.of(2, 4, 6, false),
				Arguments.of(4, 2, 6, false),
				Arguments.of(2, 0, 2, true),
				Arguments.of(0, 4, 4, true),
				Arguments.of(-2, 4, 2, true),
				Arguments.of(2, -4, -2, true)
		);
	}

	@ParameterizedTest
	@MethodSource("argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
		if (!expectException) {
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		} else {
			assertThatThrownBy(() -> testDemo.addPositive(a, b)).isInstanceOf(IllegalArgumentException.class);
		}
	}

	@Test
	void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {
		assertThat(testDemo.addPositive(4, 5)).isEqualTo(9);
		assertThat(testDemo.addPositive(40, 50)).isEqualTo(90);
		assertThatThrownBy(() -> testDemo.addPositive(0, 40)).isInstanceOf(IllegalArgumentException.class);
	}

	private static Stream<Arguments> argumentsForAddNegative() {
		return Stream.of(
				Arguments.of(-2, -4, -6, false),
				Arguments.of(-4, -2, -6, false),
				Arguments.of(-2, 0, -2, true),
				Arguments.of(0, -4, -4, true),
				Arguments.of(2, -4, -2, true),
				Arguments.of(-2, 4, 2, true));
	}

	@ParameterizedTest
	@MethodSource("argumentsForAddNegative")
	void assertThatTwoNegativeNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
		if (!expectException) {
			assertThat(testDemo.addNegative(a, b)).isEqualTo(expected);
		} else {
			assertThatThrownBy(() -> testDemo.addNegative(a, b)).isInstanceOf(IllegalArgumentException.class);
		}
	}

	@Test
	void assertThatNumberSquaredIsCorrect() {
		TestDemo mockDemo = spy(testDemo);
				
		doReturn(5).when(mockDemo).getRandomInt();
		
		int fiveSquared = mockDemo.randomNumberSquared();
		
		assertThat(fiveSquared).isEqualTo(25);
		
	}
}

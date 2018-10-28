package com.challenge.engine.utils;

import com.challenge.exception.InvalidOptionException;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;


public class InputUtilsTest {

//    @Test(expected = InvalidOptionException.class)
//    public void validateIntegerInputMustThrowInvalidOptionExceptionWithNullInputAndOptions() {
//        //given
//        final String input = null;
//        final List<Integer> availableOptions = null;
//
//        //when
//        InputUtils.validateIntegerInput(input, availableOptions);
//    }
//
//    @Test(expected = InvalidOptionException.class)
//    public void validateIntegerInputMustThrowInvalidOptionExceptionWithNotNumericInputAndValidOptions() {
//        //given
//        final String input = "A";
//        final List<Integer> availableOptions = asList(1, 2);
//
//        //when
//        InputUtils.validateIntegerInput(input, availableOptions);
//    }
//
//    @Test(expected = InvalidOptionException.class)
//    public void validateIntegerInputMustThrowInvalidOptionExceptionWithNumericInputAndNullValidOptions() {
//        //given
//        final String input = "1";
//        final List<Integer> availableOptions = null;
//
//        //when
//        InputUtils.validateIntegerInput(input, availableOptions);
//    }
//
//    @Test(expected = InvalidOptionException.class)
//    public void validateIntegerInputMustThrowInvalidOptionExceptionWithNumericInputAndEmptyValidOptions() {
//        //given
//        final String input = "1";
//        final List<Integer> availableOptions = emptyList();
//
//        //when
//        InputUtils.validateIntegerInput(input, availableOptions);
//    }
//
//    @Test
//    public void validateIntegerInputMustReturnIntegerWithNumericInputAndSingleValidOption() {
//        //given
//        final String input = "1";
//        final List<Integer> availableOptions = singletonList(1);
//
//        //when
//        InputUtils.validateIntegerInput(input, availableOptions);
//    }
//
//    @Test
//    public void validateIntegerInputMustReturnIntegerWithNumericInputAndMultipleValidOptions() {
//        //given
//        final String input = "2";
//        final List<Integer> availableOptions = asList(1, 2, 3);
//
//        //when
//        final Integer result = InputUtils.validateIntegerInput(input, availableOptions);
//
//        //then
//        assertThat(result).isEqualTo(2);
//    }
}
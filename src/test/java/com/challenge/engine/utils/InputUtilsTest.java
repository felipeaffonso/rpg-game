package com.challenge.engine.utils;

import com.challenge.exception.InvalidOptionException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.List;
import java.util.Scanner;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest(InputUtils.class)
public class InputUtilsTest {

    @Mock
    private Scanner scanner;

    @InjectMocks
    private InputUtils target;

    @Test(expected = InvalidOptionException.class)
    public void validateIntegerInputMustThrowInvalidOptionExceptionWithNullInputAndOptions() {
        //given
        final List<Integer> availableOptions = null;
        when(this.scanner.next()).thenReturn(null);

        //when
        target.validateIntegerInput(availableOptions);
    }

    @Test(expected = InvalidOptionException.class)
    public void validateIntegerInputMustThrowInvalidOptionExceptionWithNotNumericInputAndValidOptions() {
        //given
        when(this.scanner.next()).thenReturn("A");
        final List<Integer> availableOptions = asList(1, 2);

        //when
        target.validateIntegerInput(availableOptions);
    }

    @Test(expected = InvalidOptionException.class)
    public void validateIntegerInputMustThrowInvalidOptionExceptionWithNumericInputAndNullValidOptions() {
        //given
        when(this.scanner.next()).thenReturn("2");
        final List<Integer> availableOptions = null;

        //when
        target.validateIntegerInput(availableOptions);
    }

    @Test(expected = InvalidOptionException.class)
    public void validateIntegerInputMustThrowInvalidOptionExceptionWithNumericInputAndEmptyValidOptions() {
        //given
        when(this.scanner.next()).thenReturn("2");
        final List<Integer> availableOptions = emptyList();

        //when
        target.validateIntegerInput(availableOptions);
    }

    @Test
    public void validateIntegerInputMustReturnIntegerWithNumericInputAndMultipleValidOptions() {
        //given
        when(this.scanner.next()).thenReturn("2");
        final List<Integer> availableOptions = asList(1, 2, 3);

        //when
        final Integer result = target.validateIntegerInput(availableOptions);

        //then
        assertThat(result).isEqualTo(2);
    }

    @Test(expected = InvalidOptionException.class)
    public void validateStringInputMustThrowInvalidOptionExceptionWithNullInput() {
        //given
        when(this.scanner.next()).thenReturn(null);

        //when
        target.validateStringInput();
    }

    @Test(expected = InvalidOptionException.class)
    public void validateStringInputMustThrowInvalidOptionExceptionWithEmtpyInput() {
        //given
        when(this.scanner.next()).thenReturn("");

        //when
        target.validateStringInput();
    }

    @Test
    public void validateStringInputMustReturnIntegerWithNumericInput() {
        //given
        final String validString = "String";
        when(this.scanner.next()).thenReturn(validString);

        //when
        final String result = target.validateStringInput();

        //then
        assertThat(result).isEqualTo(validString);
    }

    @Test(expected = InvalidOptionException.class)
    public void validateStringInputMustThrowInvalidOptionExceptionWhenScannerThrowsException() {
        //given
        final Exception nullPointerException = new NullPointerException();
        when(this.scanner.next()).thenThrow(nullPointerException);

        //when
        target.validateStringInput();
    }

}
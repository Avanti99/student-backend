package com.example.student.exception;

public class StudentExistException extends Exception {
    private static final long serialVersionUID = 1904585489531578456L;

    public StudentExistException(String msg) {
        super(msg);
    }
}

package model.error;

public class FileFormatException extends RuntimeException
{
    public FileFormatException()
    {

    }

    public FileFormatException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
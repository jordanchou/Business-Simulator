package controller;

public interface Updateable<T>
{
    public abstract void update();
    public long getYear();
    public int compareTo(T e);
}
package view;

import model.property.*;
import java.util.*;

public interface UserInterface
{
    public void update(List<Company> companies, long year);

    public void output(Exception e);

    public void run();
}

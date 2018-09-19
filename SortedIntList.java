//**********************************************************************************************************************
//  SortedIntList.java
//
//  Child class of IntList that creates sorted list objects.
//**********************************************************************************************************************

public class SortedIntList extends IntList
{
    public SortedIntList(int size)
    {
        super(size);
        list = new int[size];
    }

    // Overridden add method.
    public void add(int value)
    {
        if (numElements == list.length)
            System.out.println("Cannot add anymore integers, list is full!");

        else
            {
            for (int i = 0; i < list.length; i++) {
                if (list[i] == 0)
                {
                    list[i] = value;
                    numElements++;
                    break;
                }

                else if (value <= list[i])
                {
                    for (int j = numElements; j > i; j--)
                        list[j] = list[j - 1];

                    list[i] = value;

                    numElements++;
                    break;
                }
            }
        }
    }
}

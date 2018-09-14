//----------------------------------------------------------------------------------------------------------------------
//  Queue.java
//  Author: Abrar Rouf
//  Creates class Queue that implements a FIFO queue that stores Objects using a circular buffer.
//----------------------------------------------------------------------------------------------------------------------

class Queue
{
    Object[] data;

    int in = 0;
    int out = 0;
    int size = 0;
    int capacity = 0;

    // Non-default constructor for Queue.
    //-----------------------------------
    Queue(int capacity)
    {
        this.capacity = capacity;
        data = new Object[capacity];
    }

    void insert(Object o)
    {
        if (size < capacity)
        {
            if (in >= capacity) in = 0;
            data[in] = o;
            in++;
            size++;
        }
    }

    void remove()
    {
        int out = in - size;
        if (out < 0) out += size;
        data[out] = null;
        size--;
    }

    boolean isFull()
    {
        return size == capacity;
    }

    Object getObject(int i)
    {
        return data[i];
    }

    int getSize()
    {
        return size;
    }

    int getCapacity()
    {
        return capacity;
    }
}



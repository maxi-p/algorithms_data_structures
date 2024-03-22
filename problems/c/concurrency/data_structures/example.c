#include <stdio.h>
#include <pthread.h>

void *computation(void *add);

int main()
{
  // pthread_t will be used to uniquely identify, create, and manage threads
  pthread_t thread1;
  pthread_t thread2;
  pthread_t thread3;
  pthread_t thread4;
  pthread_t thread5;
  pthread_t thread6;
  pthread_t thread7;
  pthread_t thread8;
  
  long value1 = 1;
  long value2 = 2;
  long value3 = 3;
  long value4 = 4;
  long value5 = 5;
  long value6 = 6;
  long value7 = 7;
  long value8 = 8;

  // computation( (void *) &value1);
  // computation( (void *) &value2);
  // computation( (void *) &value3);
  // computation( (void *) &value4);
  // computation( (void *) &value5);
  // computation( (void *) &value6);
  // computation( (void *) &value7);
  // computation( (void *) &value8);
  
  // Create two threads that will each run the computation function, one is 
  // passed a void-casted pointer to value1 as an argument, the other is 
  // passed a void-cased pointer to value2 as an argument.
  pthread_create(&thread1, NULL, computation, (void*) &value1);
  pthread_create(&thread2, NULL, computation, (void*) &value2);
  pthread_create(&thread3, NULL, computation, (void*) &value3);
  pthread_create(&thread4, NULL, computation, (void*) &value4);
  pthread_create(&thread5, NULL, computation, (void*) &value5);
  pthread_create(&thread6, NULL, computation, (void*) &value6);
  pthread_create(&thread7, NULL, computation, (void*) &value7);
  pthread_create(&thread8, NULL, computation, (void*) &value8);
  
  // execution will pause at pthread_join until the thread provided as an 
  // argument has completed its execution
  pthread_join(thread1, NULL);
  pthread_join(thread2, NULL);
  pthread_join(thread3, NULL);
  pthread_join(thread4, NULL);
  pthread_join(thread5, NULL);
  pthread_join(thread6, NULL);
  pthread_join(thread7, NULL);
  pthread_join(thread8, NULL);

  return 0;
}

// Accepts a void pointer and returns a void pointer as pthread_create expects
// both of these properties.  We pass in a value via the void pointer.  The 
// function does some meaningless work to simulate meaningful computational 
// working occurring.
void *computation(void *add)
{
  long sum = 0;

  // cast the void pointer add to a long pointer
  long *add_num = (long *) (add);
  
  // de-reference add_num to get at the value pointed to by add_num, have 
  // the loop run many, many times doing some computational work
  for (long i = 0; i < 1000000000; i++)
    sum += *add_num;

  return NULL;
}

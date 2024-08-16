#include <time.h>
#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>

#define NUMCPUS 4

typedef struct non__counter_t
{
    int value;
} non_counter_t;

void non_init(non_counter_t *c)
{
    c->value = 0;
}
void increment(non_counter_t *c)
{
    c->value++;
}

void decrement(non_counter_t *c)
{
    c->value--;
}

typedef struct __counter_t
{
    int global;                     // global count
    pthread_mutex_t glock;          // global lock
    int local[NUMCPUS];             // per-CPU count
    pthread_mutex_t llock[NUMCPUS]; // ... and locks
    int threshold;                  // update freq
} counter_t;

// init: record threshold, init locks, init values
// of all local counts and global count
void init(counter_t *c, int threshold)
{
    c->threshold = threshold;
    c->global = 0;
    pthread_mutex_init(&c->glock, NULL);
    int i;
    for (i = 0; i < NUMCPUS; i++)
    {
        c->local[i] = 0;
        pthread_mutex_init(&c->llock[i], NULL);
    }
}
// update: usually, just grab local lock and update
// local amount; once it has risen ’threshold’,
// grab global lock and transfer local values to it
void update(counter_t *c, int threadID, int amt)
{
    int cpu = threadID % NUMCPUS;
    if(cpu == 0){
        printf("1\n");
    }
    if(cpu == 1){
        printf("\t2\n");
    }
    if(cpu == 2){
        printf("\t\t3\n");
    }
    if(cpu == 3){
        printf("\t\t\t4\n");
    }
    pthread_mutex_lock(&c->llock[cpu]);
    c->local[cpu] += amt;
    if (c->local[cpu] >= c->threshold)
    {
        // transfer to global (assumes amt>0)
        pthread_mutex_lock(&c->glock);
        c->global += c->local[cpu];
        pthread_mutex_unlock(&c->glock);
        c->local[cpu] = 0;
    }
    pthread_mutex_unlock(&c->llock[cpu]);
}
// get: just return global amount (approximate)
int get(counter_t *c)
{
    pthread_mutex_lock(&c->glock);
    int val = c->global;
    pthread_mutex_unlock(&c->glock);
    return val; // only approximate!
}

void *concurrent_count1(void *arg)
{
    int j=0;
    // counter_t *ctr = (counter_t *)arg;
    for (int i = 0; i < 1000000; i++)
    {
        // j++;
        printf("1\n");
        // update(ctr, 1, 1);
    }

    return NULL;
}
void *concurrent_count2(void *arg)
{
    int j=0;
    // counter_t *ctr = (counter_t *)arg;
    for (int i = 0; i < 1000000; i++)
    {
        // j++;
        printf("\t2\n");
        // update(ctr, 2, 1);
    }

    return NULL;
}
void *concurrent_count3(void *arg)
{
    int j=0;
    // counter_t *ctr = (counter_t *)arg;
    for (int i = 0; i < 1000000; i++)
    {
        // j++;
        printf("\t\t3\n");
        // update(ctr, 3, 1);
    }

    return NULL;
}
void *concurrent_count4(void *arg)
{   
    int j=0;
    // counter_t *ctr = (counter_t *)arg;
    for (int i = 0; i < 1000000; i++)
    {
        // j++;
        printf("\t\t\t4\n");
        // update(ctr, 4, 1);
    }

    return NULL;
}

int main(void)
{
    clock_t t;
    int test =0;
    int threshhold;
    non_counter_t non_concurrent;
    pthread_t t1, t2, t3, t4;
    counter_t concurrent;
    double time_taken;
    double time_taken2;

    threshhold = 1000000;
    non_init(&non_concurrent);
    init(&concurrent, threshhold);

    // start
    // t = clock();

    // for (long i = 0; i < 4000000; i++)
    // {
    //     //    test++;        
    //     printf("1\n");
    // }
    // finish
    // t = clock() - t;

    time_taken2 = ((double)t) / CLOCKS_PER_SEC; // in seconds


    // t = clock();

    pthread_create(&t1, NULL, concurrent_count1, &concurrent);
    pthread_create(&t2, NULL, concurrent_count2, &concurrent);
    pthread_create(&t3, NULL, concurrent_count3, &concurrent);
    pthread_create(&t4, NULL, concurrent_count4, &concurrent);
    pthread_join(t1, NULL);
    pthread_join(t2, NULL);
    pthread_join(t3, NULL);
    pthread_join(t4, NULL);

    // t = clock() - t;
    time_taken = ((double)t) / CLOCKS_PER_SEC; // in seconds

    printf("Non-concurrent counter executed in %f seconds\n", time_taken2);
    printf("Result is: %d \n", non_concurrent.value);
    printf("Concurrent counter executed in %f seconds\n", time_taken);
    printf("Result is: %d \n", concurrent.global);
    return 0;
}
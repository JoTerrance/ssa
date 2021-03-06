#include <iostream>

#include "gtest/gtest.h"
#include "../src/include/Savings.h"




void segfault_sigaction(int signal, siginfo_t *si, void *arg)
{
    printf("Caught segfault at address %p\n", si->si_addr);
    exit(0);
}




void disableSegmentationFault() {
    struct sigaction sa;
    memset(&sa, 0, sizeof(struct sigaction));
    sigemptyset(&sa.sa_mask);
    sa.sa_sigaction = segfault_sigaction;
    sa.sa_flags   = SA_SIGINFO;
    sigaction(SIGSEGV, &sa, NULL);
}




TEST(buffer_overflow_test_case, buffer_overflow_test){
    disableSegmentationFault();
    Savings* object = new Savings();
    object->bufferOverflow();
}




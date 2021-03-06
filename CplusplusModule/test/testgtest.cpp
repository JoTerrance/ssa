#include <iostream>
#include <fstream>
#include "gtest/gtest.h"
#include "../src/include/Savings.h"


TEST(dangling_pointer_test_case, dangling_pointer_test) {
    Savings *object = new Savings();
    Savings *object2 = object;

    delete object;
    object = nullptr;
    std::cout << &object << std::endl;
    std::cout << &object2 << std::endl;
    ASSERT_TRUE(object == NULL);
    ASSERT_TRUE(object2 != NULL);
}

TEST(integer_overflow_test_case, integer_overflow_test) {
    unsigned short x = 65535;  // largest 2-byte unsigned value possible
    ASSERT_TRUE(x == 65535);
    std::cout << "x was: " << x << std::endl;
    x = x + 1;      // We assumed for 65536, but we get overflow here !
    std::cout << "x is now: " << x << std::endl;
    ASSERT_TRUE(x == 0);

}
//FIO03-CPP. Do not make assumptions about fopen() and file creation
TEST(fopen_test_case, fopen_test) {
    FILE *fp = fopen("foo.txt", "wx");
    FILE *fp1 = fopen("foo.txt", "wx");
    ASSERT_TRUE(fp);
    ASSERT_TRUE(!fp1);

    fclose(fp);
    remove("foo.txt");
}


TEST(truncation_string_case, truncation_string_test) {

    char test[11];
    std::string strComplete( "Hello, world" );
    strComplete.copy(test,5);
    std::cout << std::endl;
    std::cout << test << std::endl;

}


//STR02-CPP. Sanitize data passed to complex subsystems
TEST(sanitize_string_test_case, sanitize_string_test) {

    char *buffer;
    char *addr;
    sprintf(buffer, "/bin/mail %s < /home/gorka/GIT/ssa/CplusplusModule/test/email", addr);
    system(buffer);
}


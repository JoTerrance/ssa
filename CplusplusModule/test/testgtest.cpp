#include <iostream>

#include "gtest/gtest.h"
#include "../src/include/Savings.h"
#include<stdio.h>



TEST(dangling_pointer_test_case, dangling_pointer_test)
{
    Savings *object = new Savings();
    Savings *object2 = object;

    delete object;
    object = nullptr;
    std::cout << &object << std::endl;
    std::cout << &object2 << std::endl;
    ASSERT_TRUE(object == NULL);
    ASSERT_TRUE(object2 != NULL);
}
from conans import ConanFile, CMake

class SecureSoftwareConan(ConanFile):
   settings = "os", "compiler", "build_type", "arch"
   requires = "gtest/1.8.0@lasote/stable"
   generators = "cmake", "gcc", "txt"

   def imports(self):
      self.copy("*.dll", dst="bin", src="bin") # From bin to bin
      self.copy("*.dylib*", dst="bin", src="lib") # From lib to bin

   def build(self):
      cmake = CMake(self.settings)
      cmake.configure(self)
      cmake.build(self)
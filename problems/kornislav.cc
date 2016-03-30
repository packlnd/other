#include <iostream>
#include <vector>
#include <algorithm>

int main() {
  int a,b,c,d;
  std::cin >> a >> b >> c >> d;
  std::vector<int> v = {a,b,c,d};
  std::sort(v.begin(),v.end());
  std::cout << v[0]*v[2] << std::endl;
}

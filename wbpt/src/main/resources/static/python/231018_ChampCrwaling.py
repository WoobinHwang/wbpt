from selenium import webdriver
from selenium.webdriver.common.keys import Keys
import time

driver = webdriver.Chrome()
driver.get("https://game.naver.com/lounge/League_of_Legends/db/champion")
# 로딩시간 필요하여 3초간 쉬기
time.sleep(3)

fir= ".card_content-header__title__oJkdR"
# target : 챔피언 박스 list
target= driver.find_elements_by_css_selector(fir)

sec= ".gamedb_icon__1jSHy"
# more : 더보기 버튼
more= driver.find_element_by_css_selector(sec)

# 더보기 누를때 continue 출력
# 더보기 없을때 break 출력
while True:

    try:
        more.click()
        time.sleep(1)
        more= driver.find_element_by_css_selector(sec)
        print("continue")

    except Exception as error:
        
        print("break")
        print(error)
        print("step")
        break
# 더보기 버튼 끝까지 클릭하기

# 이름 출력
names= []
for i in target:    
    names.append(i.text)
print(names)

thi = ".card_thumbnail__image__2xUgG"
img= driver.find_elements_by_css_selector(thi)
images= []
for i in img:
    images.append(i.get_attribute('src'))
print(len(images))

# 종료 단계
driver.close()
print("end...")
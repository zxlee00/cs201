import ijson

review_file = "C:/Users/Zhi Xuan/Dropbox/My PC (LAPTOP-TARUL13L)/Documents/Downloads/yelp_dataset/yelp_academic_dataset_review.json"
user_file = "C:/Users/Zhi Xuan/Dropbox/My PC (LAPTOP-TARUL13L)/Documents/Downloads/yelp_dataset/yelp_academic_dataset_user.json"
business_file = "C:/Users/Zhi Xuan/Dropbox/My PC (LAPTOP-TARUL13L)/Documents/Downloads/yelp_dataset/yelp_academic_dataset_business.json"

with open(business_file, encoding='utf-8') as f:
    objects = ijson.items(f, '', multiple_values = True)
    i = 0

    for o in objects:
        if o["categories"] != None and "Restaurant" in o["categories"]:
            i += 1 

print(i)

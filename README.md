سلام به همه

یک کتابخانه ساده برای تشخیص نوع فایل یک آدرس اینترنتی.

شاید شما برنامه ای داشته باشید که نیاز داره در اون یک آدرس مثلا عکس توسط کاربر داده بشه که قبلش شما باید بررسی کنین که آیا این واقعا یک آدرس عکس هست!؟

خوب این کتاب خونه جوابه 😊

## نحوه اضافه کردن به برنامه

برای اضافه کردن کتابخانه در گریدل این رو اضافه کنین:
```java
implementation 'com.github.seyedjavadmajidi:extensiontools:0.3’
```
## نحوه استفاده

برای بررسی یک فایل که مثلا حتما عکس باشه به روش زیر:
```java
ArrayList<String> mims = new ArrayList<String>();
mims.add("image/jpeg");
mims.add("image/png");

if (jMimeType.CheckWithMimetype(mims, "https://softjam.ir/1.jpg"))
   MessageSuccess("Ok");
else
   MessageFailure("Error");
```

یه روش دیگه اینکه فقط ما مد نظرمون jpg هست نه هیچ فرمت عکس دیگه ای:
```java
ArrayList<String> mims = new ArrayList<String>();
mims.add("jpg");
mims.add("png");

if (jMimeType.CheckWithExtension(mims, "https://softjam.ir/1.jpg"))
   MessageSuccess("Ok");
else
   MessageFailure("Error");
```
میتونین آمار یک آدرس اینترنتی رو در بیارین که این نوع فایل یا پسوندش چی هست:
```java
jMimeType.GetExtensionFromUrlAdvanced("https://softjam.ir/1.jpg");
```

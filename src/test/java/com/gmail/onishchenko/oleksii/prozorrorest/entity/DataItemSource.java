package com.gmail.onishchenko.oleksii.prozorrorest.entity;

import java.time.ZonedDateTime;
import java.util.AbstractMap;
import java.util.Map;
import java.util.stream.Stream;

public interface DataItemSource {
    default Stream<Map.Entry<DataItem, String>> dataItemSourceFirst() {
        return Stream.of(
                new AbstractMap.SimpleImmutableEntry<>(
                        DataItemBuilder.getInstance()
                                .hash("md5:232dba893a22ac722249ad92f8bccf22")
                                .format(Format.TEXT_PLAIN)
                                .url("https://public-docs-sandbox.prozorro.gov.ua/get/" +
                                        "3500487074064bd98f1076c21fe69e9a?KeyID=1331dc52&Signature=w" +
                                        "%252BTQLJCiU%2FDQXfp%2FxB0VfDNRzImPv7zch3e8H1jfVOZrDJZuam%2FOTVLlvpdUiz9WVLHdUzdMrQJclbl4Vs28CQ%253D%253D")
                                .title("11.09.2018.xlsx")
                                .documentOf(DocumentOf.TENDER)
                                .datePublished(ZonedDateTime.parse("2018-09-19T13:12:21.136232+03:00"))
                                .documentType(DocumentType.SUB_CONTRACT)
                                .dateModified(ZonedDateTime.parse("2018-09-19T13:12:21.136263+03:00"))
                                .id("4f6d6dc59d1844bb80143ccc2e727a2f")
                                .build(),
                        "{" +
                                "\"hash\":\"md5:232dba893a22ac722249ad92f8bccf22\"," +
                                "\"format\":\"text/plain\"," +
                                "\"url\":\"https://public-docs-sandbox.prozorro.gov.ua/get/3500487074064bd98f1076c21fe69e9a?" +
                                "KeyID=1331dc52&Signature=w" +
                                "%252BTQLJCiU%2FDQXfp%2FxB0VfDNRzImPv7zch3e8H1jfVOZrDJZuam%2FOTVLlvpdUiz9WVLHdUzdMrQJclbl4Vs28CQ%253D%253D\"," +
                                "\"title\":\"11.09.2018.xlsx\"," +
                                "\"documentOf\":\"tender\"," +
                                "\"datePublished\":\"2018-09-19T13:12:21.136232+03:00\"," +
                                "\"documentType\":\"subContract\"," +
                                "\"dateModified\":\"2018-09-19T13:12:21.136263+03:00\"," +
                                "\"id\":\"4f6d6dc59d1844bb80143ccc2e727a2f\"" +
                                "}"

                ),
                new AbstractMap.SimpleImmutableEntry<>(
                        DataItemBuilder.getInstance()
                                .hash("md5:ee80acf16c48f3b659a2132526ae9800")
                                .format(Format.APPLICATION_PKCS7_SIGNATURE)
                                .url("https://public-docs-sandbox.prozorro.gov.ua/get/" +
                                        "04a93d0ba3e44e7e93a104a1b1ec8aaf?KeyID=1331dc52&Signature" +
                                        "=o1V0G3cmFYjuu7MqIJxTY9zhDAj7PTblieehL0PEG%2FA5uc0VZlpY%252BMhQy0ZxTPdymnkPvAVxivDEodSI4RFDCw%253D%253D")
                                .title("sign.p7s")
                                .documentOf(DocumentOf.TENDER)
                                .datePublished(ZonedDateTime.parse("2018-09-19T13:13:07.776613+03:00"))
                                .dateModified(ZonedDateTime.parse("2018-09-19T13:13:07.776633+03:00"))
                                .id("a5ef4c3063d94b10a13630fa9cca90b9")
                                .build(),
                        "{" +
                                "\"hash\":\"md5:ee80acf16c48f3b659a2132526ae9800\"," +
                                "\"format\":\"application/pkcs7-signature\"," +
                                "\"url\":\"https://public-docs-sandbox.prozorro.gov.ua/get/" +
                                "04a93d0ba3e44e7e93a104a1b1ec8aaf?KeyID=1331dc52&Signature=o1V0G3cmFYjuu7MqIJxTY9zhDAj7" +
                                "PTblieehL0PEG%2FA5uc0VZlpY%252BMhQy0ZxTPdymnkPvAVxivDEodSI4RFDCw%253D%253D\"," +
                                "\"title\":\"sign.p7s\"," +
                                "\"documentOf\":\"tender\"," +
                                "\"datePublished\":\"2018-09-19T13:13:07.776613+03:00\"," +
                                "\"dateModified\":\"2018-09-19T13:13:07.776633+03:00\"," +
                                "\"id\":\"a5ef4c3063d94b10a13630fa9cca90b9\"" +
                                "}"
                ),
                new AbstractMap.SimpleImmutableEntry<>(
                        DataItemBuilder.getInstance()
                                .hash("md5:061044f40512fa72e03c2674d1539e0f")
                                .format(Format.TEXT_PLAIN)
                                .url("https://public-docs-sandbox.prozorro.gov.ua/get/5e03ef2402bd42ddb7dc78d526c95f81?" +
                                        "KeyID=1331dc52&Signature=VjKGxj7WlIe%252BqZpE4OJl1qtIt0VQJ%2FMff8n8KaJWVHDANkFZB%252BcZbsq%2Fr" +
                                        "%252BzW6S81cqeSU9hYlLLnq1WGpJ%252BuCQ%253D%253D")
                                .title("\u0442\u0435\u0441\u0442.docx")
                                .documentOf(DocumentOf.CHANGE)
                                .datePublished(ZonedDateTime.parse("2018-09-24T16:00:29.527286+03:00"))
                                .dateModified(ZonedDateTime.parse("2018-09-24T16:00:29.527311+03:00"))
                                .relatedItem("6167ab1f7a184f75881b166b9c2e9193")
                                .id("f58353848e744791ad72f9baf84b5734")
                                .build(),
                        "{" +
                                "\"hash\":\"md5:061044f40512fa72e03c2674d1539e0f\"," +
                                "\"format\":\"text/plain\"," +
                                "\"url\":\"https://public-docs-sandbox.prozorro.gov.ua/get/" +
                                "5e03ef2402bd42ddb7dc78d526c95f81?KeyID=1331dc52&Signature" +
                                "=VjKGxj7WlIe%252BqZpE4OJl1qtIt0VQJ%2FMff8n8KaJWVHDANkFZB%252BcZbsq" +
                                "%2Fr%252BzW6S81cqeSU9hYlLLnq1WGpJ%252BuCQ%253D%253D\"," +
                                "\"title\":\"\\u0442\\u0435\\u0441\\u0442.docx\"," +
                                "\"documentOf\":\"change\"," +
                                "\"datePublished\":\"2018-09-24T16:00:29.527286+03:00\"," +
                                "\"dateModified\":\"2018-09-24T16:00:29.527311+03:00\"," +
                                "\"relatedItem\":\"6167ab1f7a184f75881b166b9c2e9193\"," +
                                "\"id\":\"f58353848e744791ad72f9baf84b5734\"" +
                                "}"
                )
        );
    }

    default Stream<Map.Entry<DataItem, String>> dataItemSourceSecond() {
        return Stream.of(
                new AbstractMap.SimpleImmutableEntry<>(
                        DataItemBuilder.getInstance()
                                .hash("md5:787caaf33e54d10e6cd302bce098564c")
                                .description("")
                                .format(Format.APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_SPREADSHEETML)
                                .url("https://public-docs-sandbox.prozorro.gov.ua/get/" +
                                        "69966a5cbdf94ea9a7420ade7d97ca56?KeyID=1331dc52&Signature" +
                                        "=7feOocmK9uCwci0%2FrHMXl4jScyfOTK7XQjnRsJLIZFN21Z9hRDjeZJrrVn4XXiqGjgOSQ6XKtTggvJHe6G8cDQ%253D%253D")
                                .title("\u0414\u043e\u0434\u0430\u0442\u043a\u043e\u0432\u0430 \u0443\u0433\u043e\u0434\u0430.xlsx")
                                .documentOf(DocumentOf.TENDER)
                                .datePublished(ZonedDateTime.parse("2018-10-08T15:13:06.456131+03:00"))
                                .documentType(DocumentType.CONTRACT_SIGNED)
                                .dateModified(ZonedDateTime.parse("2018-10-08T15:13:06.456152+03:00"))
                                .id("c973e26efa78408c8cf7adbb3c2b11e5")
                                .build(),
                        "{" +
                                "\"hash\":\"md5:787caaf33e54d10e6cd302bce098564c\"," +
                                "\"description\":\"\"," +
                                "\"format\":\"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet\"," +
                                "\"url\":\"https://public-docs-sandbox.prozorro.gov.ua/get/" +
                                "69966a5cbdf94ea9a7420ade7d97ca56?KeyID=1331dc52&Signature" +
                                "=7feOocmK9uCwci0%2FrHMXl4jScyfOTK7XQjnRsJLIZFN21Z9hRDjeZJrrVn4XXiqGjgOSQ6XKtTggvJHe6G8cDQ%253D%253D\"," +
                                "\"title\":\"\\u0414\\u043E\\u0434\\u0430\\u0442\\u043A\\u043E\\u0432\\u0430 \\u0443\\u0433\\u043E\\u0434\\u0430.xlsx\"," +
                                "\"documentOf\":\"tender\"," +
                                "\"datePublished\":\"2018-10-08T15:13:06.456131+03:00\"," +
                                "\"documentType\":\"contractSigned\"," +
                                "\"dateModified\":\"2018-10-08T15:13:06.456152+03:00\"," +
                                "\"id\":\"c973e26efa78408c8cf7adbb3c2b11e5\"" +
                                "}"

                ),
                new AbstractMap.SimpleImmutableEntry<>(
                        DataItemBuilder.getInstance()
                                .hash("md5:ba8ca1580920293ebb33a1dfdb4b74fe")
                                .format(Format.APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_WORDPROCESSINGML)
                                .url("https://public-docs-sandbox.prozorro.gov.ua/get/" +
                                        "766cc889cc2343fbb7ce802022cabd9b?KeyID=1331dc52&Signature" +
                                        "=UuYK9aRGFVDCJdIXNkZnbYPvrnlmSVkLZZmJ2l%252BII7Uc1btir26W0wbT4qFe4CpajDb81%252BI5kYZ5cOQ92uJlDw%253D%253D")
                                .title("\u041f\u0435\u0440\u0435\u043b\u0456\u043a \u0437\u043c\u0456\u043d.docx")
                                .documentOf(DocumentOf.CHANGE)
                                .datePublished(ZonedDateTime.parse("2018-10-17T11:53:01.587843+03:00"))
                                .documentType(DocumentType.CONTRACT_ANNEXE)
                                .dateModified(ZonedDateTime.parse("2018-10-17T11:53:01.587874+03:00"))
                                .relatedItem("028162fdf8634010ac1296b11e685602")
                                .id("3b6a91e9c7154f6ebf5e8a8d5c11a357")
                                .build(),
                        "{" +
                                "\"hash\":\"md5:ba8ca1580920293ebb33a1dfdb4b74fe\"," +
                                "\"format\":\"application/vnd.openxmlformats-officedocument.wordprocessingml.document\"," +
                                "\"url\":\"https://public-docs-sandbox.prozorro.gov.ua/get/" +
                                "766cc889cc2343fbb7ce802022cabd9b?KeyID=1331dc52&Signature" +
                                "=UuYK9aRGFVDCJdIXNkZnbYPvrnlmSVkLZZmJ2l%252BII7Uc1btir26W0wbT4qFe4CpajDb81%252BI5kYZ5cOQ92uJlDw%253D%253D\"," +
                                "\"title\":\"\\u041F\\u0435\\u0440\\u0435\\u043B\\u0456\\u043A \\u0437\\u043C\\u0456\\u043D.docx\"," +
                                "\"documentOf\":\"change\"," +
                                "\"datePublished\":\"2018-10-17T11:53:01.587843+03:00\"," +
                                "\"documentType\":\"contractAnnexe\"," +
                                "\"dateModified\":\"2018-10-17T11:53:01.587874+03:00\"," +
                                "\"relatedItem\":\"028162fdf8634010ac1296b11e685602\"," +
                                "\"id\":\"3b6a91e9c7154f6ebf5e8a8d5c11a357\"" +
                                "}"
                ),
                new AbstractMap.SimpleImmutableEntry<>(
                        DataItemBuilder.getInstance()
                                .hash("md5:fc4a6b43f2162a74d3de4905f6939d11")
                                .format(Format.APPLICATION_PKCS7_SIGNATURE)
                                .url("https://public-docs-sandbox.prozorro.gov.ua/get/" +
                                        "77dab55ea98f401688397fa6faa449ce?KeyID=1331dc52&Signature" +
                                        "=yTE1DjbaU2dmrWrFgKwRiuj%2FF8SNosqRRoPZnaNNXmBRHOAp%2FyqITRzlCSEV3bpipWBZns%252BzBso%252BMoZBIC1ZAw%253D%253D")
                                .title("sign.p7s")
                                .documentOf(DocumentOf.CONTRACT)
                                .datePublished(ZonedDateTime.parse("2018-10-17T11:54:16.657833+03:00"))
                                .dateModified(ZonedDateTime.parse("2018-10-17T11:54:16.657854+03:00"))
                                .id("f99bb2ce17c144f3a28f665a9206ab92")
                                .build(),
                        "{" +
                                "\"hash\":\"md5:fc4a6b43f2162a74d3de4905f6939d11\"," +
                                "\"format\":\"application/pkcs7-signature\"," +
                                "\"url\":\"https://public-docs-sandbox.prozorro.gov.ua/get/" +
                                "77dab55ea98f401688397fa6faa449ce?KeyID=1331dc52&Signature" +
                                "=yTE1DjbaU2dmrWrFgKwRiuj%2FF8SNosqRRoPZnaNNXmBRHOAp%2FyqITRzlCSEV3bpipWBZns%252BzBso%252BMoZBIC1ZAw%253D%253D\"," +
                                "\"title\":\"sign.p7s\"," +
                                "\"documentOf\":\"contract\"," +
                                "\"datePublished\":\"2018-10-17T11:54:16.657833+03:00\"," +
                                "\"dateModified\":\"2018-10-17T11:54:16.657854+03:00\"," +
                                "\"id\":\"f99bb2ce17c144f3a28f665a9206ab92\"" +
                                "}"
                ),
                new AbstractMap.SimpleImmutableEntry<>(
                        DataItemBuilder.getInstance()
                                .hash("md5:ba8ca1580920293ebb33a1dfdb4b74fe")
                                .format(Format.APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_WORDPROCESSINGML)
                                .url("https://public-docs-sandbox.prozorro.gov.ua/get/" +
                                        "d89e4e84fee241ebbbed07a6728dd9c7?KeyID=1331dc52&Signature" +
                                        "=qDPX1LbM41tEWl3%2FDgpm6u%2F806x2qb6jddF68KRwbFNbz1S0I62vsiD8Q%252B5dfTEkqY%252BgYZJM%2FrpDsQNI90qWDg%253D%253D")
                                .title("\u041f\u0435\u0440\u0435\u043b\u0456\u043a \u0437\u043c\u0456\u043d.docx")
                                .documentOf(DocumentOf.CHANGE)
                                .datePublished(ZonedDateTime.parse("2018-10-17T15:56:22.886361+03:00"))
                                .documentType(DocumentType.CONTRACT_ANNEXE)
                                .dateModified(ZonedDateTime.parse("2018-10-17T15:56:22.886383+03:00"))
                                .relatedItem("eec9a01f0c3f4884a3edb5bcf9c66b8f")
                                .id("e7bf347964704ae98efba0d04b5232bb")
                                .build(),
                        "{" +
                                "\"hash\":\"md5:ba8ca1580920293ebb33a1dfdb4b74fe\"," +
                                "\"format\":\"application/vnd.openxmlformats-officedocument.wordprocessingml.document\"," +
                                "\"url\":\"https://public-docs-sandbox.prozorro.gov.ua/get/" +
                                "d89e4e84fee241ebbbed07a6728dd9c7?KeyID=1331dc52&Signature" +
                                "=qDPX1LbM41tEWl3%2FDgpm6u%2F806x2qb6jddF68KRwbFNbz1S0I62vsiD8Q%252B5dfTEkqY%252BgYZJM%2FrpDsQNI90qWDg%253D%253D\"," +
                                "\"title\":\"\\u041F\\u0435\\u0440\\u0435\\u043B\\u0456\\u043A \\u0437\\u043C\\u0456\\u043D.docx\"," +
                                "\"documentOf\":\"change\"," +
                                "\"datePublished\":\"2018-10-17T15:56:22.886361+03:00\"," +
                                "\"documentType\":\"contractAnnexe\"," +
                                "\"dateModified\":\"2018-10-17T15:56:22.886383+03:00\"," +
                                "\"relatedItem\":\"eec9a01f0c3f4884a3edb5bcf9c66b8f\"," +
                                "\"id\":\"e7bf347964704ae98efba0d04b5232bb\"" +
                                "}"
                )
        );
    }


    default Stream<Map.Entry<DataItem, String>> dataItemSourceThird() {
        return Stream.of(
                new AbstractMap.SimpleImmutableEntry<>(
                        DataItemBuilder.getInstance()
                                .hash("md5:aa8f3e480ef09f68a3ba29d38526a54d")
                                .format(Format.IMAGE_JPEG)
                                .url("https://public-docs-sandbox.prozorro.gov.ua/get/f104698a64f64bdf8142f7e11df74dd2?" +
                                        "KeyID=1331dc52&Signature=oi3cRoqISdyAb4f0wEM" +
                                        "%252B43P8Mn1eh19YH%2FGwQkoHWlLDnQWWwFhZeXGvZStKoaJ8yDh%252B5JRy%252BTm4UNyzetDoCQ%253D%253D")
                                .title("19WII9x.jpg")
                                .documentOf(DocumentOf.TENDER)
                                .datePublished(ZonedDateTime.parse("2018-11-15T10:46:48.083543+02:00"))
                                .dateModified(ZonedDateTime.parse("2018-11-15T10:46:48.083564+02:00"))
                                .id("219c45e36e4548f4963a484642420478")
                                .build(),
                        "{" +
                                "\"hash\":\"md5:aa8f3e480ef09f68a3ba29d38526a54d\"," +
                                "\"format\":\"image/jpeg\"," +
                                "\"url\":\"https://public-docs-sandbox.prozorro.gov.ua/get/f104698a64f64bdf8142f7e11df74dd2?"
                                + "KeyID=1331dc52&Signature=oi3cRoqISdyAb4f0wEM" +
                                "%252B43P8Mn1eh19YH%2FGwQkoHWlLDnQWWwFhZeXGvZStKoaJ8yDh%252B5JRy%252BTm4UNyzetDoCQ%253D%253D\"," +
                                "\"title\":\"19WII9x.jpg\"," +
                                "\"documentOf\":\"tender\"," +
                                "\"datePublished\":\"2018-11-15T10:46:48.083543+02:00\"," +
                                "\"dateModified\":\"2018-11-15T10:46:48.083564+02:00\"," +
                                "\"id\":\"219c45e36e4548f4963a484642420478\"" +
                                "}"
                ),
                new AbstractMap.SimpleImmutableEntry<>(
                        DataItemBuilder.getInstance()
                                .hash("md5:dcc8b429838b29c8c6bbbd565b1f9b45")
                                .format(Format.IMAGE_PNG)
                                .url("https://public-docs-sandbox.prozorro.gov.ua" +
                                        "/get/010690c6dba24402851d4e40fea90eb5?KeyID=1331dc52&Signature=" +
                                        "RT7pybVmIlXm3QA2yOTbFyxtKtUzdeyemepwOAgbtqSeHz66x2dlhx%2FVnUX83dIo6leJzmhCJsUNVldMkwjMAw%253D%253D")
                                .title("zak_fb.png")
                                .documentOf(DocumentOf.CHANGE)
                                .documentType(DocumentType.CONTRACT_ANNEXE)
                                .datePublished(ZonedDateTime.parse("2018-11-15T10:56:40.740846+02:00"))
                                .dateModified(ZonedDateTime.parse("2018-11-15T10:56:40.740870+02:00"))
                                .relatedItem("a45ec75e09b7461aaa7218d66b23f018")
                                .id("b3f936cd9e214387881aecdbdcc1aeff")
                                .build(),
                        "{" +
                                "\"hash\":\"md5:dcc8b429838b29c8c6bbbd565b1f9b45\"," +
                                "\"format\":\"image/png\"," +
                                "\"url\":\"https://public-docs-sandbox.prozorro.gov.ua" +
                                "/get/010690c6dba24402851d4e40fea90eb5?KeyID=1331dc52&Signature=RT7pybVmIlXm3QA2yOTbFyxtKtUzdeyemepwOAgbtqSeHz66x2dlhx" +
                                "%2FVnUX83dIo6leJzmhCJsUNVldMkwjMAw%253D%253D\"," +
                                "\"title\":\"zak_fb.png\"," +
                                "\"documentOf\":\"change\"," +
                                "\"datePublished\":\"2018-11-15T10:56:40.740846+02:00\"," +
                                "\"documentType\":\"contractAnnexe\"," +
                                "\"dateModified\":\"2018-11-15T10:56:40.740870+02:00\"," +
                                "\"relatedItem\":\"a45ec75e09b7461aaa7218d66b23f018\"," +
                                "\"id\":\"b3f936cd9e214387881aecdbdcc1aeff\"" +
                                "}"
                ),
                new AbstractMap.SimpleImmutableEntry<>(
                        DataItemBuilder.getInstance()
                                .hash("md5:aa8f3e480ef09f68a3ba29d38526a54d")
                                .language(Language.UK)
                                .format(Format.IMAGE_JPEG)
                                .url("https://public-docs-sandbox.prozorro.gov.ua" +
                                        "/get/5bdfd8cefd634da988084378da57f306?KeyID=1331dc52&Signature=ak8O" +
                                        "%2FooCoP2yTootrSk1kLamJAmhd%252BUCPHIvh6VrMGZPnk7n3gn0pygPvCs1mK9kTYEd93ubaDiEyHQbzpNIBw%253D%253D")
                                .title("19WII9x.jpg")
                                .documentOf(DocumentOf.CONTRACT)
                                .datePublished(ZonedDateTime.parse("2018-11-15T11:22:51.416943+02:00"))
                                .dateModified(ZonedDateTime.parse("2018-11-15T11:22:51.416995+02:00"))
                                .id("44c098109cd2496880d7943e3921d80f")
                                .build(),
                        "{" +
                                "\"hash\":\"md5:aa8f3e480ef09f68a3ba29d38526a54d\"," +
                                "\"language\":\"uk\"," +
                                "\"format\":\"image/jpeg\"," +
                                "\"url\":\"https://public-docs-sandbox.prozorro.gov.ua" +
                                "/get/5bdfd8cefd634da988084378da57f306?KeyID=1331dc52&Signature=ak8O" +
                                "%2FooCoP2yTootrSk1kLamJAmhd%252BUCPHIvh6VrMGZPnk7n3gn0pygPvCs1mK9kTYEd93ubaDiEyHQbzpNIBw%253D%253D\"," +
                                "\"title\":\"19WII9x.jpg\"," +
                                "\"documentOf\":\"contract\"," +
                                "\"datePublished\":\"2018-11-15T11:22:51.416943+02:00\"," +
                                "\"dateModified\":\"2018-11-15T11:22:51.416995+02:00\"," +
                                "\"id\":\"44c098109cd2496880d7943e3921d80f\"" +
                                "}"

                )

        );


    }
}

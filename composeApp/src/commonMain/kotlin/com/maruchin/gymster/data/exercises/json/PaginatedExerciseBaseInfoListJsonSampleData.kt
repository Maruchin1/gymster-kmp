package com.maruchin.gymster.data.exercises.json

internal val samplePaginatedExerciseBaseInfoListJson = """
    {
      "count": 544,
      "next": "https://wger.de/api/v2/exercisebaseinfo/?limit=20&offset=20",
      "previous": null,
      "results": [
        {
          "id": 31,
          "uuid": "f2733700-aa5d-4df7-bc52-1876ab4fb479",
          "created": "2023-08-06T10:17:17.422900+02:00",
          "last_update": "2024-01-17T11:21:01.706493+01:00",
          "last_update_global": "2024-01-17T11:21:01.908320+01:00",
          "category": {
            "id": 8,
            "name": "Arms"
          },
          "muscles": [],
          "muscles_secondary": [],
          "equipment": [
            {
              "id": 3,
              "name": "Dumbbell"
            }
          ],
          "license": {
            "id": 1,
            "full_name": " Creative Commons Attribution Share Alike 3",
            "short_name": "CC-BY-SA 3",
            "url": "https://creativecommons.org/licenses/by-sa/3.0/deed.en"
          },
          "license_author": "GrosseHund",
          "images": [],
          "exercises": [
            {
              "id": 289,
              "uuid": "6add5973-86d0-4543-928a-6bb8b3f34efc",
              "name": "Axe Hold",
              "exercise_base": 31,
              "description": "<p>Grab dumbbells and extend arms to side and hold as long as you can</p>",
              "created": "2023-08-06T10:17:17.349574+02:00",
              "language": 2,
              "aliases": [],
              "notes": [],
              "license": 1,
              "license_title": "",
              "license_object_url": "",
              "license_author": "GrosseHund",
              "license_author_url": "",
              "license_derivative_source_url": "",
              "author_history": [
                "GrosseHund"
              ]
            },
            {
              "id": 677,
              "uuid": "8e9d8968-323d-468c-9174-8cf11a105fad",
              "name": "Axe Hold",
              "exercise_base": 31,
              "description": "<p>Nehmen Sie die Hanteln und strecken Sie die Arme zur Seite. Halten Sie sie so lange wie möglich.</p>",
              "created": "2023-08-06T10:17:17.349574+02:00",
              "language": 1,
              "aliases": [],
              "notes": [],
              "license": 1,
              "license_title": "",
              "license_object_url": "",
              "license_author": "GrosseHund",
              "license_author_url": "",
              "license_derivative_source_url": "",
              "author_history": [
                "GrosseHund",
                "Wunschcoach"
              ]
            }
          ],
          "variations": null,
          "videos": [],
          "author_history": [
            "GrosseHund"
          ],
          "total_authors_history": [
            "GrosseHund",
            "Wunschcoach"
          ]
        },
        {
          "id": 56,
          "uuid": "03db11cc-8079-463c-9399-6f346b100ce6",
          "created": "2023-08-06T10:17:17.422900+02:00",
          "last_update": "2024-01-17T11:21:02.089512+01:00",
          "last_update_global": "2024-01-17T11:21:02.595866+01:00",
          "category": {
            "id": 10,
            "name": "Abs"
          },
          "muscles": [
            {
              "id": 6,
              "name": "Rectus abdominis",
              "name_en": "Abs",
              "is_front": true,
              "image_url_main": "/static/images/muscles/main/muscle-6.svg",
              "image_url_secondary": "/static/images/muscles/secondary/muscle-6.svg"
            }
          ],
          "muscles_secondary": [
            {
              "id": 14,
              "name": "Obliquus externus abdominis",
              "name_en": "",
              "is_front": true,
              "image_url_main": "/static/images/muscles/main/muscle-14.svg",
              "image_url_secondary": "/static/images/muscles/secondary/muscle-14.svg"
            }
          ],
          "equipment": [
            {
              "id": 4,
              "name": "Gym mat"
            }
          ],
          "license": {
            "id": 1,
            "full_name": " Creative Commons Attribution Share Alike 3",
            "short_name": "CC-BY-SA 3",
            "url": "https://creativecommons.org/licenses/by-sa/3.0/deed.en"
          },
          "license_author": "andikeller",
          "images": [],
          "exercises": [
            {
              "id": 1061,
              "uuid": "60d8018d-296f-4c62-a80b-f609a25d34ea",
              "name": "Abdominal Stabilization",
              "exercise_base": 56,
              "description": "",
              "created": "2023-08-06T10:17:17.349574+02:00",
              "language": 2,
              "aliases": [],
              "notes": [],
              "license": 1,
              "license_title": "",
              "license_object_url": "",
              "license_author": "andikeller",
              "license_author_url": "",
              "license_derivative_source_url": "",
              "author_history": [
                "andikeller",
                "wger.de"
              ]
            },
            {
              "id": 259,
              "uuid": "c659577f-d9de-4e39-bcd1-1b0bf1f62d11",
              "name": "Bauch Stabilisation",
              "exercise_base": 56,
              "description": "<p>Auf Rolle liegend</p>",
              "created": "2023-08-06T10:17:17.349574+02:00",
              "language": 1,
              "aliases": [],
              "notes": [],
              "license": 1,
              "license_title": "",
              "license_object_url": "",
              "license_author": "andikeller",
              "license_author_url": "",
              "license_derivative_source_url": "",
              "author_history": [
                "andikeller"
              ]
            }
          ],
          "variations": null,
          "videos": [],
          "author_history": [
            "andikeller"
          ],
          "total_authors_history": [
            "andikeller",
            "wger.de"
          ]
        },
        {
          "id": 805,
          "uuid": "ea63d85c-8579-4dda-b99f-c4c8930f9af6",
          "created": "2023-08-06T10:17:17.422900+02:00",
          "last_update": "2024-01-17T11:21:03.018786+01:00",
          "last_update_global": "2024-04-04T15:15:18.085757+02:00",
          "category": {
            "id": 8,
            "name": "Arms"
          },
          "muscles": [
            {
              "id": 5,
              "name": "Triceps brachii",
              "name_en": "Triceps",
              "is_front": false,
              "image_url_main": "/static/images/muscles/main/muscle-5.svg",
              "image_url_secondary": "/static/images/muscles/secondary/muscle-5.svg"
            }
          ],
          "muscles_secondary": [],
          "equipment": [],
          "license": {
            "id": 2,
            "full_name": "Creative Commons Attribution Share Alike 4",
            "short_name": "CC-BY-SA 4",
            "url": "https://creativecommons.org/licenses/by-sa/4.0/deed.en"
          },
          "license_author": "cshep442",
          "images": [
            {
              "id": 362,
              "uuid": "ba006cae-44ca-46a9-bb71-6f5d4fa130e9",
              "exercise_base": 805,
              "exercise_base_uuid": "ea63d85c-8579-4dda-b99f-c4c8930f9af6",
              "image": "https://wger.de/media/exercise-images/805/ba006cae-44ca-46a9-bb71-6f5d4fa130e9.png",
              "is_main": true,
              "style": "4",
              "license": 2,
              "license_title": "",
              "license_object_url": "",
              "license_author": "Franpol",
              "license_author_url": "",
              "license_derivative_source_url": "",
              "author_history": [
                "Franpol"
              ]
            }
          ],
          "exercises": [
            {
              "id": 2081,
              "uuid": "7460a7bc-4490-46aa-a4bb-883ab22ef171",
              "name": "Empuje de tríceps en cable",
              "exercise_base": 805,
              "description": "El empuje hacia abajo de la cuerda del cable es un ejercicio popular dirigido a los músculos tríceps. Es fácil de aprender y realizar, lo que lo convierte en el favorito de todos, desde principiantes hasta levantadores avanzados. Por lo general, se realiza para repeticiones de moderadas a altas, como 8-12 repeticiones o más por serie, como parte de un entrenamiento centrado en la parte superior del cuerpo o en los brazos.",
              "created": "2023-08-06T10:17:17.349574+02:00",
              "language": 4,
              "aliases": [],
              "notes": [],
              "license": 2,
              "license_title": "",
              "license_object_url": "",
              "license_author": "cshep442",
              "license_author_url": "",
              "license_derivative_source_url": "",
              "author_history": [
                "cshep442",
                "Franpol"
              ]
            },
            {
              "id": 2225,
              "uuid": "37eaf7ae-772d-4d34-ad95-6b727432c371",
              "name": "Flessioni dei Tricipiti al Cavo",
              "exercise_base": 805,
              "description": "Il push-down con la corda è un esercizio molto popolare per i tricipiti. È facile da imparare e da eseguire, per cui è il preferito da tutti, dai sollevatori principianti agli esperti. Di solito viene eseguito con ripetizioni moderate o elevate, come 8-12 ripetizioni o più per serie, parte di un allenamento per la parte superiore del corpo o incentrato per le braccia.",
              "created": "2024-04-03T16:22:49.679122+02:00",
              "language": 13,
              "aliases": [],
              "notes": [],
              "license": 2,
              "license_title": "",
              "license_object_url": "",
              "license_author": "FEFFO",
              "license_author_url": "",
              "license_derivative_source_url": "",
              "author_history": [
                "FEFFO"
              ]
            },
            {
              "id": 1073,
              "uuid": "51595d74-afe2-4445-88ec-2a289251e710",
              "name": "Tricep Pushdown on Cable",
              "exercise_base": 805,
              "description": "The cable rope push-down is a popular exercise targeting the triceps muscles. It's easy to learn and perform, making it a favorite for everyone from beginners to advanced lifters. It is usually performed for moderate to high reps, such as 8-12 reps or more per set, as part of an upper-body or arm-focused workout.",
              "created": "2023-08-06T10:17:17.349574+02:00",
              "language": 2,
              "aliases": [],
              "notes": [],
              "license": 2,
              "license_title": "",
              "license_object_url": "",
              "license_author": "cshep442",
              "license_author_url": "",
              "license_derivative_source_url": "",
              "author_history": [
                "cshep442"
              ]
            }
          ],
          "variations": null,
          "videos": [],
          "author_history": [
            "cshep442"
          ],
          "total_authors_history": [
            "Franpol",
            "cshep442",
            "FEFFO"
          ]
        },
        {
          "id": 981,
          "uuid": "9e6dae29-5d03-440a-bdf1-2cb25a5179c2",
          "created": "2023-08-06T10:17:17.422900+02:00",
          "last_update": "2024-01-17T11:21:04.796780+01:00",
          "last_update_global": "2024-01-17T11:21:05.775867+01:00",
          "category": {
            "id": 9,
            "name": "Legs"
          },
          "muscles": [],
          "muscles_secondary": [],
          "equipment": [
            {
              "id": 8,
              "name": "Bench"
            }
          ],
          "license": {
            "id": 2,
            "full_name": "Creative Commons Attribution Share Alike 4",
            "short_name": "CC-BY-SA 4",
            "url": "https://creativecommons.org/licenses/by-sa/4.0/deed.en"
          },
          "license_author": null,
          "images": [],
          "exercises": [
            {
              "id": 1506,
              "uuid": "4ef74871-44bb-43b3-acfb-8c221ad06bd2",
              "name": "Adım atma",
              "exercise_base": 981,
              "description": "<ol><li>Sandalyeye dönük şekilde durun</li><li>Sandalyeye çıkın</li><li>Sandalyeden inin</li><li>Tekrarlayın</li></ol>",
              "created": "2023-08-06T10:17:17.349574+02:00",
              "language": 16,
              "aliases": [],
              "notes": [],
              "license": 2,
              "license_title": "",
              "license_object_url": "",
              "license_author": null,
              "license_author_url": "",
              "license_derivative_source_url": "",
              "author_history": [
                "ToldYouThat (imported from Feeel)",
                "Oğuz Ersen (imported from Feeel)",
                "mondstern (imported from Feeel)"
              ]
            },
            {
              "id": 1501,
              "uuid": "f8720d72-e04e-4008-bdae-77d791d26ae4",
              "name": "Marches",
              "exercise_base": 981,
              "description": "<ol><li>Tenez-vous debout face à une chaise</li><li>Montez sur la chaise</li><li>Descendez de la chaise</li><li>Répétez</li></ol>",
              "created": "2023-08-06T10:17:17.349574+02:00",
              "language": 12,
              "aliases": [],
              "notes": [],
              "license": 2,
              "license_title": "",
              "license_object_url": "",
              "license_author": null,
              "license_author_url": "",
              "license_derivative_source_url": "",
              "author_history": [
                "Clément Mondon (imported from Feeel)",
                "Miroslav Mazel (imported from Feeel)",
                "Maxime Leroy (imported from Feeel)",
                "Jonathan D. (imported from Feeel)",
                "mondstern (imported from Feeel)",
                "J. Lavoie (imported from Feeel)"
              ]
            },
            {
              "id": 1504,
              "uuid": "2c500679-beaa-4717-baf8-b2eab2b1bc89",
              "name": "Opstappen",
              "exercise_base": 981,
              "description": "<ol><li>Ga voor een stoel staan.</li><li>Ga op de stoel staan.</li><li>Ga van de stoel af.</li><li>Herhaal</li></ol>",
              "created": "2023-08-06T10:17:17.349574+02:00",
              "language": 6,
              "aliases": [],
              "notes": [],
              "license": 2,
              "license_title": "",
              "license_object_url": "",
              "license_author": null,
              "license_author_url": "",
              "license_derivative_source_url": "",
              "author_history": [
                "Heimen Stoffels (imported from Feeel)",
                "Daan Vervacke (imported from Feeel)",
                "mondstern (imported from Feeel)",
                "J. Lavoie (imported from Feeel)",
                "floris van den bosch (imported from Feeel)"
              ]
            },
            {
              "id": 1505,
              "uuid": "1155ce91-a11b-488d-8751-ffb0e403fcbe",
              "name": "Progressos",
              "exercise_base": 981,
              "description": "<ol><li>Fique de pé de frente para uma cadeira</li><li>Suba na cadeira</li><li>Desça da cadeira</li><li>Repita</li></ol>",
              "created": "2023-08-06T10:17:17.349574+02:00",
              "language": 7,
              "aliases": [],
              "notes": [],
              "license": 2,
              "license_title": "",
              "license_object_url": "",
              "license_author": null,
              "license_author_url": "",
              "license_derivative_source_url": "",
              "author_history": [
                "Vinicius Rodrigues (imported from Feeel)",
                "flexagoon (imported from Feeel)",
                "gbpu (imported from Feeel)",
                "Eduardo Celino (imported from Feeel)",
                "Rodolfo Candido (imported from Feeel)",
                "mondstern (imported from Feeel)"
              ]
            },
            {
              "id": 1498,
              "uuid": "1cc35af7-6ddf-4a1c-82f3-1974087cb2ee",
              "name": "Steigungen",
              "exercise_base": 981,
              "description": "<p>Ausgangsposition:</p><p>Stellen Sie sich vor einen Stuhl.</p><p>Schritte:</p><ol><li>Steigen Sie auf den Stuhl.</li><li>Steigen Sie vom Stuhl ab.</li><li>Wiederholen Sie</li></ol>",
              "created": "2023-08-06T10:17:17.349574+02:00",
              "language": 1,
              "aliases": [],
              "notes": [],
              "license": 2,
              "license_title": "",
              "license_object_url": "",
              "license_author": null,
              "license_author_url": "",
              "license_derivative_source_url": "",
              "author_history": [
                "mondstern (imported from Feeel)",
                "Miroslav Mazel (imported from Feeel)"
              ]
            },
            {
              "id": 1503,
              "uuid": "a35e8b34-4c04-47ea-bf71-e19af6872dda",
              "name": "Step",
              "exercise_base": 981,
              "description": "<ol><li>Stare in piedi di fronte a una sedia</li><li>Salire sulla sedia</li><li>Scendere dalla sedia</li><li>Ripeti</li></ol>",
              "created": "2023-08-06T10:17:17.349574+02:00",
              "language": 13,
              "aliases": [],
              "notes": [],
              "license": 2,
              "license_title": "",
              "license_object_url": "",
              "license_author": null,
              "license_author_url": "",
              "license_derivative_source_url": "",
              "author_history": [
                "Gianluca Vespignani (imported from Feeel)",
                "albanobattistella (imported from Feeel)",
                "mondstern (imported from Feeel)",
                "J. Lavoie (imported from Feeel)",
                "Marco Galli (imported from Feeel)"
              ]
            },
            {
              "id": 1496,
              "uuid": "08ae9edf-d375-4265-a24d-2f1ae71c3fc0",
              "name": "Step-up",
              "exercise_base": 981,
              "description": "<ol><li>Berdiri menghadap kursi</li><li>Naik ke kursi</li><li>Step off the chair</li><li>Ulangi</li></ol>",
              "created": "2023-08-06T10:17:17.349574+02:00",
              "language": 23,
              "aliases": [],
              "notes": [],
              "license": 2,
              "license_title": "",
              "license_object_url": "",
              "license_author": null,
              "license_author_url": "",
              "license_derivative_source_url": "",
              "author_history": [
                "mondstern (imported from Feeel)",
                "Reza Almanda (imported from Feeel)"
              ]
            },
            {
              "id": 1499,
              "uuid": "7a7339d1-c4fa-4513-bd4c-8312922e87b0",
              "name": "Step-ups",
              "exercise_base": 981,
              "description": "<p>Starting position:</p><p>Stand facing a chair.</p><p>Steps:</p><ol><li>Step up onto the chair.</li><li>Step off the chair.</li><li>Repeat.</li></ol>",
              "created": "2023-08-06T10:17:17.349574+02:00",
              "language": 2,
              "aliases": [
                {
                  "id": 514,
                  "uuid": "f0c967fc-4008-40d7-964b-867ba0a5748c",
                  "alias": "Chair steps"
                }
              ],
              "notes": [],
              "license": 2,
              "license_title": "",
              "license_object_url": "",
              "license_author": null,
              "license_author_url": "",
              "license_derivative_source_url": "",
              "author_history": [
                "Miroslav Mazel (imported from Feeel)"
              ]
            },
            {
              "id": 1502,
              "uuid": "92895e8a-8652-4ebe-b112-3efaf2cab67e",
              "name": "Stupanje na stolicu",
              "exercise_base": 981,
              "description": "<ol><li>Stani ispred stolca</li><li>Zakorači na stolac</li><li>Siđi sa stolca</li><li>Ponovi</li></ol>",
              "created": "2023-08-06T10:17:17.349574+02:00",
              "language": 22,
              "aliases": [],
              "notes": [],
              "license": 2,
              "license_title": "",
              "license_object_url": "",
              "license_author": null,
              "license_author_url": "",
              "license_derivative_source_url": "",
              "author_history": [
                "Milo Ivir (imported from Feeel)"
              ]
            },
            {
              "id": 1500,
              "uuid": "4bb64b4b-a1a3-464f-8a54-be459930206a",
              "name": "Subida a peldaño",
              "exercise_base": 981,
              "description": "<ol><li>Párese frente a una silla</li><li>Súbase a la silla</li><li>Bájese de la silla</li><li>Repita</li></ol>",
              "created": "2023-08-06T10:17:17.349574+02:00",
              "language": 4,
              "aliases": [],
              "notes": [],
              "license": 2,
              "license_title": "",
              "license_object_url": "",
              "license_author": null,
              "license_author_url": "",
              "license_derivative_source_url": "",
              "author_history": [
                "Diego Sanguinetti (imported from Feeel)",
                "Gabriel Tandil (imported from Feeel)",
                "mondstern (imported from Feeel)",
                "Luis Alfredo Figueroa Bracamontes (imported from Feeel)"
              ]
            },
            {
              "id": 1497,
              "uuid": "61209149-74b1-4ebb-8de5-86704ce23390",
              "name": "Výšlapy",
              "exercise_base": 981,
              "description": "<ol><li>Stůj čelem k židli.</li><li>Stoupni si na židli</li><li>Sestup dolu ze židle</li><li>Opakuj</li></ol>",
              "created": "2023-08-06T10:17:17.349574+02:00",
              "language": 9,
              "aliases": [],
              "notes": [],
              "license": 2,
              "license_title": "",
              "license_object_url": "",
              "license_author": null,
              "license_author_url": "",
              "license_derivative_source_url": "",
              "author_history": [
                "Shimon (imported from Feeel)",
                "mondstern (imported from Feeel)",
                "Miroslav Mazel (imported from Feeel)"
              ]
            },
            {
              "id": 1507,
              "uuid": "4a001139-c8a3-4f09-96d1-75759fb30599",
              "name": "Σκαλιά",
              "exercise_base": 981,
              "description": "<ol><li>Σταθείτε κοιτάζοντας μια καρέκλα</li><li>Ανεβείτε στην καρέκλα</li><li>Κατεβείτε από την καρέκλα</li><li>Επαναλάβετε</li></ol>",
              "created": "2023-08-06T10:17:17.349574+02:00",
              "language": 8,
              "aliases": [],
              "notes": [],
              "license": 2,
              "license_title": "",
              "license_object_url": "",
              "license_author": null,
              "license_author_url": "",
              "license_derivative_source_url": "",
              "author_history": [
                "Vangelis Skarmoutsos (imported from Feeel)"
              ]
            },
            {
              "id": 1508,
              "uuid": "dc999267-8e38-461b-b3bc-5dd4fd9f80b2",
              "name": "עליות מדרגה",
              "exercise_base": 981,
              "description": "<ol><li>לעמוד מול כיסא</li><li>לעלות על הכיסא</li><li>לרדת מהכיסא</li><li>לחזור על הפעולות</li></ol>",
              "created": "2023-08-06T10:17:17.349574+02:00",
              "language": 21,
              "aliases": [],
              "notes": [],
              "license": 2,
              "license_title": "",
              "license_object_url": "",
              "license_author": null,
              "license_author_url": "",
              "license_derivative_source_url": "",
              "author_history": [
                "Omer I.S. (imported from Feeel)"
              ]
            },
            {
              "id": 1509,
              "uuid": "eaff8366-f694-4e2b-ba9c-8f0361970d1a",
              "name": "صعود-الكرسي",
              "exercise_base": 981,
              "description": "<ol><li>الوقوف في مواجهة كرسي</li><li>اصعد على الكرسي</li><li>انزل عن الكرسي</li><li>كرر التمرين</li></ol>",
              "created": "2023-08-06T10:17:17.349574+02:00",
              "language": 17,
              "aliases": [],
              "notes": [],
              "license": 2,
              "license_title": "",
              "license_object_url": "",
              "license_author": null,
              "license_author_url": "",
              "license_derivative_source_url": "",
              "author_history": [
                "Rex_sa (imported from Feeel)"
              ]
            },
            {
              "id": 1510,
              "uuid": "a26199ce-324d-44d1-9f19-c3404c96bfcb",
              "name": "گام به گام",
              "exercise_base": 981,
              "description": "",
              "created": "2023-08-06T10:17:17.349574+02:00",
              "language": 20,
              "aliases": [],
              "notes": [],
              "license": 2,
              "license_title": "",
              "license_object_url": "",
              "license_author": null,
              "license_author_url": "",
              "license_derivative_source_url": "",
              "author_history": [
                "alefvanoon (imported from Feeel)",
                "Mohammad Hossein Tajaddini (imported from Feeel)"
              ]
            },
            {
              "id": 1511,
              "uuid": "7a5f3af3-7577-4d70-a448-fd284f2ff8fb",
              "name": "仰卧起坐",
              "exercise_base": 981,
              "description": "<p>起始姿势：面对椅子站立。</p><p>步骤：</p><ol><li>走到椅子上。</li><li>从椅子上走下来。</li><li>重复。</li></ol>",
              "created": "2023-08-06T10:17:17.349574+02:00",
              "language": 24,
              "aliases": [],
              "notes": [],
              "license": 2,
              "license_title": "",
              "license_object_url": "",
              "license_author": null,
              "license_author_url": "",
              "license_derivative_source_url": "",
              "author_history": [
                "Eric (imported from Feeel)",
                "bxezi (imported from Feeel)",
                "poi / poipoipoipoipoipoipoipoipoi (imported from Feeel)"
              ]
            }
          ],
          "variations": null,
          "videos": [],
          "author_history": [],
          "total_authors_history": [
            "Vangelis Skarmoutsos (imported from Feeel)",
            "Gianluca Vespignani (imported from Feeel)",
            "Daan Vervacke (imported from Feeel)",
            "Maxime Leroy (imported from Feeel)",
            "gbpu (imported from Feeel)",
            "Diego Sanguinetti (imported from Feeel)",
            "Gabriel Tandil (imported from Feeel)",
            "Luis Alfredo Figueroa Bracamontes (imported from Feeel)",
            "mondstern (imported from Feeel)",
            "alefvanoon (imported from Feeel)",
            "Jonathan D. (imported from Feeel)",
            "Mohammad Hossein Tajaddini (imported from Feeel)",
            "Vinicius Rodrigues (imported from Feeel)",
            "Eric (imported from Feeel)",
            "Omer I.S. (imported from Feeel)",
            "J. Lavoie (imported from Feeel)",
            "Marco Galli (imported from Feeel)",
            "floris van den bosch (imported from Feeel)",
            "ToldYouThat (imported from Feeel)",
            "Oğuz Ersen (imported from Feeel)",
            "flexagoon (imported from Feeel)",
            "Clément Mondon (imported from Feeel)",
            "Reza Almanda (imported from Feeel)",
            "Shimon (imported from Feeel)",
            "Heimen Stoffels (imported from Feeel)",
            "Milo Ivir (imported from Feeel)",
            "Eduardo Celino (imported from Feeel)",
            "Miroslav Mazel (imported from Feeel)",
            "Rodolfo Candido (imported from Feeel)",
            "poi / poipoipoipoipoipoipoipoipoi (imported from Feeel)",
            "Rex_sa (imported from Feeel)",
            "albanobattistella (imported from Feeel)",
            "bxezi (imported from Feeel)"
          ]
        },
        {
          "id": 980,
          "uuid": "e872658a-3bac-4d9e-bcf2-15919ebea43a",
          "created": "2023-08-06T10:17:17.422900+02:00",
          "last_update": "2024-01-17T11:21:05.849474+01:00",
          "last_update_global": "2024-01-17T11:21:05.940431+01:00",
          "category": {
            "id": 10,
            "name": "Abs"
          },
          "muscles": [
            {
              "id": 2,
              "name": "Anterior deltoid",
              "name_en": "Shoulders",
              "is_front": true,
              "image_url_main": "/static/images/muscles/main/muscle-2.svg",
              "image_url_secondary": "/static/images/muscles/secondary/muscle-2.svg"
            },
            {
              "id": 1,
              "name": "Biceps brachii",
              "name_en": "Biceps",
              "is_front": true,
              "image_url_main": "/static/images/muscles/main/muscle-1.svg",
              "image_url_secondary": "/static/images/muscles/secondary/muscle-1.svg"
            },
            {
              "id": 12,
              "name": "Latissimus dorsi",
              "name_en": "Lats",
              "is_front": false,
              "image_url_main": "/static/images/muscles/main/muscle-12.svg",
              "image_url_secondary": "/static/images/muscles/secondary/muscle-12.svg"
            },
            {
              "id": 9,
              "name": "Trapezius",
              "name_en": "",
              "is_front": false,
              "image_url_main": "/static/images/muscles/main/muscle-9.svg",
              "image_url_secondary": "/static/images/muscles/secondary/muscle-9.svg"
            }
          ],
          "muscles_secondary": [],
          "equipment": [
            {
              "id": 6,
              "name": "Pull-up bar"
            }
          ],
          "license": {
            "id": 2,
            "full_name": "Creative Commons Attribution Share Alike 4",
            "short_name": "CC-BY-SA 4",
            "url": "https://creativecommons.org/licenses/by-sa/4.0/deed.en"
          },
          "license_author": "clafal",
          "images": [],
          "exercises": [
            {
              "id": 1297,
              "uuid": "a3f181a1-c458-490b-924a-f81d041348ed",
              "name": "Trazioni alla sbarra commando",
              "exercise_base": 980,
              "description": "Variazione dell'esercizio trazioni alla sbarra, viene eseguito con una presa di una mano supina e di una mano prona,non torcere il busto per rimettersi frontali, la testa passa una volta da un lato, una volta dall’altro.",
              "created": "2023-08-06T10:17:17.349574+02:00",
              "language": 13,
              "aliases": [],
              "notes": [],
              "license": 2,
              "license_title": "",
              "license_object_url": "",
              "license_author": "clafal",
              "license_author_url": "",
              "license_derivative_source_url": "",
              "author_history": [
                "clafal"
              ]
            },
            {
              "id": 1296,
              "uuid": "0e2afa02-bf91-4d24-a322-6c81748a98ae",
              "name": "commando pull-ups",
              "exercise_base": 980,
              "description": "variation of the pull-up exercise, it is performed with a grip of one hand supine and one hand prone,&nbsp;do not twist the torso to get back to the front, the head passes once to one side, once to the other.",
              "created": "2023-08-06T10:17:17.349574+02:00",
              "language": 2,
              "aliases": [],
              "notes": [],
              "license": 2,
              "license_title": "",
              "license_object_url": "",
              "license_author": "clafal",
              "license_author_url": "",
              "license_derivative_source_url": "",
              "author_history": [
                "clafal"
              ]
            }
          ],
          "variations": null,
          "videos": [],
          "author_history": [
            "clafal"
          ],
          "total_authors_history": [
            "clafal"
          ]
        },
        {
          "id": 1022,
          "uuid": "768e0703-a04d-4d97-89ce-a49cd6be2b06",
          "created": "2023-08-06T10:17:17.422900+02:00",
          "last_update": "2024-01-17T11:21:06.030225+01:00",
          "last_update_global": "2024-01-17T11:21:06.069206+01:00",
          "category": {
            "id": 12,
            "name": "Back"
          },
          "muscles": [
            {
              "id": 2,
              "name": "Anterior deltoid",
              "name_en": "Shoulders",
              "is_front": true,
              "image_url_main": "/static/images/muscles/main/muscle-2.svg",
              "image_url_secondary": "/static/images/muscles/secondary/muscle-2.svg"
            },
            {
              "id": 1,
              "name": "Biceps brachii",
              "name_en": "Biceps",
              "is_front": true,
              "image_url_main": "/static/images/muscles/main/muscle-1.svg",
              "image_url_secondary": "/static/images/muscles/secondary/muscle-1.svg"
            },
            {
              "id": 13,
              "name": "Brachialis",
              "name_en": "",
              "is_front": true,
              "image_url_main": "/static/images/muscles/main/muscle-13.svg",
              "image_url_secondary": "/static/images/muscles/secondary/muscle-13.svg"
            },
            {
              "id": 12,
              "name": "Latissimus dorsi",
              "name_en": "Lats",
              "is_front": false,
              "image_url_main": "/static/images/muscles/main/muscle-12.svg",
              "image_url_secondary": "/static/images/muscles/secondary/muscle-12.svg"
            },
            {
              "id": 14,
              "name": "Obliquus externus abdominis",
              "name_en": "",
              "is_front": true,
              "image_url_main": "/static/images/muscles/main/muscle-14.svg",
              "image_url_secondary": "/static/images/muscles/secondary/muscle-14.svg"
            },
            {
              "id": 6,
              "name": "Rectus abdominis",
              "name_en": "Abs",
              "is_front": true,
              "image_url_main": "/static/images/muscles/main/muscle-6.svg",
              "image_url_secondary": "/static/images/muscles/secondary/muscle-6.svg"
            },
            {
              "id": 3,
              "name": "Serratus anterior",
              "name_en": "",
              "is_front": true,
              "image_url_main": "/static/images/muscles/main/muscle-3.svg",
              "image_url_secondary": "/static/images/muscles/secondary/muscle-3.svg"
            }
          ],
          "muscles_secondary": [],
          "equipment": [
            {
              "id": 10,
              "name": "Kettlebell"
            }
          ],
          "license": {
            "id": 2,
            "full_name": "Creative Commons Attribution Share Alike 4",
            "short_name": "CC-BY-SA 4",
            "url": "https://creativecommons.org/licenses/by-sa/4.0/deed.en"
          },
          "license_author": null,
          "images": [
            {
              "id": 273,
              "uuid": "f74644fa-f43e-46bd-8603-6e3a2ee8ee2d",
              "exercise_base": 1022,
              "exercise_base_uuid": "768e0703-a04d-4d97-89ce-a49cd6be2b06",
              "image": "https://wger.de/media/exercise-images/1022/f74644fa-f43e-46bd-8603-6e3a2ee8ee2d.jpg",
              "is_main": true,
              "style": "4",
              "license": 2,
              "license_title": "",
              "license_object_url": "",
              "license_author": null,
              "license_author_url": "",
              "license_derivative_source_url": "",
              "author_history": []
            },
            {
              "id": 274,
              "uuid": "eef8fb9d-ae72-4e23-81da-4d62f2734332",
              "exercise_base": 1022,
              "exercise_base_uuid": "768e0703-a04d-4d97-89ce-a49cd6be2b06",
              "image": "https://wger.de/media/exercise-images/1022/eef8fb9d-ae72-4e23-81da-4d62f2734332.jpg",
              "is_main": false,
              "style": "4",
              "license": 2,
              "license_title": "",
              "license_object_url": "",
              "license_author": null,
              "license_author_url": "",
              "license_derivative_source_url": "",
              "author_history": []
            }
          ],
          "exercises": [
            {
              "id": 1970,
              "uuid": "18e63909-6fb4-4517-865e-d7ae85dc877e",
              "name": "Kettlebell swing a una mano",
              "exercise_base": 1022,
              "description": "Come un normale swing con kettelbell, solo con un braccio. Gambe divaricate alla larghezza delle spalle, inizia con il kettelbell tra le gambe e fallo oscillare davanti a te mentre allunghi le gambe, quindi riportalo indietro tra le gambe.",
              "created": "2023-08-06T10:17:17.349574+02:00",
              "language": 13,
              "aliases": [],
              "notes": [],
              "license": 2,
              "license_title": "",
              "license_object_url": "",
              "license_author": null,
              "license_author_url": "",
              "license_derivative_source_url": "",
              "author_history": [
                "clafal"
              ]
            },
            {
              "id": 1965,
              "uuid": "7366fcb9-76f4-4903-b181-d530b1451531",
              "name": "Single Arm Plank to Row",
              "exercise_base": 1022,
              "description": "Start position as row, extend to plank and back. Finish with row and repeat",
              "created": "2023-08-06T10:17:17.349574+02:00",
              "language": 2,
              "aliases": [],
              "notes": [],
              "license": 2,
              "license_title": "",
              "license_object_url": "",
              "license_author": null,
              "license_author_url": "",
              "license_derivative_source_url": "",
              "author_history": []
            }
          ],
          "variations": null,
          "videos": [],
          "author_history": [],
          "total_authors_history": [
            "clafal"
          ]
        },
        {
          "id": 820,
          "uuid": "0ecd5f3a-f156-4f1b-b29e-16fb80802a50",
          "created": "2023-08-06T10:17:17.422900+02:00",
          "last_update": "2024-01-17T11:21:06.108747+01:00",
          "last_update_global": "2024-01-17T11:21:06.127447+01:00",
          "category": {
            "id": 8,
            "name": "Arms"
          },
          "muscles": [],
          "muscles_secondary": [],
          "equipment": [],
          "license": {
            "id": 2,
            "full_name": "Creative Commons Attribution Share Alike 4",
            "short_name": "CC-BY-SA 4",
            "url": "https://creativecommons.org/licenses/by-sa/4.0/deed.en"
          },
          "license_author": "marcelbader",
          "images": [],
          "exercises": [
            {
              "id": 1074,
              "uuid": "11437c81-ca9e-4670-a9df-2ddf2566f419",
              "name": "Fingerboard 20 mm edge",
              "exercise_base": 820,
              "description": "Hang for 10 seconds on a fingerboard with a 20 mm edge",
              "created": "2023-08-06T10:17:17.349574+02:00",
              "language": 2,
              "aliases": [],
              "notes": [],
              "license": 2,
              "license_title": "",
              "license_object_url": "",
              "license_author": "marcelbader",
              "license_author_url": "",
              "license_derivative_source_url": "",
              "author_history": [
                "marcelbader"
              ]
            },
            {
              "id": 1075,
              "uuid": "eff8a009-cded-4ebd-a83f-fe7a17d07529",
              "name": "Leisten hängen an 20 mm Kante",
              "exercise_base": 820,
              "description": "10 Sekunden&nbsp;an einer 20 mm Leiste des Fingerboards hängen",
              "created": "2023-08-06T10:17:17.349574+02:00",
              "language": 1,
              "aliases": [],
              "notes": [],
              "license": 2,
              "license_title": "",
              "license_object_url": "",
              "license_author": "marcelbader",
              "license_author_url": "",
              "license_derivative_source_url": "",
              "author_history": [
                "marcelbader"
              ]
            }
          ],
          "variations": null,
          "videos": [],
          "author_history": [
            "marcelbader"
          ],
          "total_authors_history": [
            "marcelbader"
          ]
        },
        {
          "id": 822,
          "uuid": "5d244235-cd56-472a-876e-6e530a899ef2",
          "created": "2023-08-06T10:17:17.422900+02:00",
          "last_update": "2024-01-17T11:21:06.155824+01:00",
          "last_update_global": "2024-01-17T11:21:06.161125+01:00",
          "category": {
            "id": 13,
            "name": "Shoulders"
          },
          "muscles": [
            {
              "id": 2,
              "name": "Anterior deltoid",
              "name_en": "Shoulders",
              "is_front": true,
              "image_url_main": "/static/images/muscles/main/muscle-2.svg",
              "image_url_secondary": "/static/images/muscles/secondary/muscle-2.svg"
            },
            {
              "id": 9,
              "name": "Trapezius",
              "name_en": "",
              "is_front": false,
              "image_url_main": "/static/images/muscles/main/muscle-9.svg",
              "image_url_secondary": "/static/images/muscles/secondary/muscle-9.svg"
            }
          ],
          "muscles_secondary": [
            {
              "id": 5,
              "name": "Triceps brachii",
              "name_en": "Triceps",
              "is_front": false,
              "image_url_main": "/static/images/muscles/main/muscle-5.svg",
              "image_url_secondary": "/static/images/muscles/secondary/muscle-5.svg"
            }
          ],
          "equipment": [],
          "license": {
            "id": 2,
            "full_name": "Creative Commons Attribution Share Alike 4",
            "short_name": "CC-BY-SA 4",
            "url": "https://creativecommons.org/licenses/by-sa/4.0/deed.en"
          },
          "license_author": "cshep442",
          "images": [
            {
              "id": 216,
              "uuid": "74affc0d-03b6-4f33-b5f4-a822a2615f68",
              "exercise_base": 822,
              "exercise_base_uuid": "5d244235-cd56-472a-876e-6e530a899ef2",
              "image": "https://wger.de/media/exercise-images/822/74affc0d-03b6-4f33-b5f4-a822a2615f68.png",
              "is_main": true,
              "style": "4",
              "license": 2,
              "license_title": "",
              "license_object_url": "",
              "license_author": "cshep442",
              "license_author_url": "",
              "license_derivative_source_url": "",
              "author_history": [
                "cshep442"
              ]
            },
            {
              "id": 217,
              "uuid": "6a770e5d-cd62-4754-a18c-eebe2103d7c5",
              "exercise_base": 822,
              "exercise_base_uuid": "5d244235-cd56-472a-876e-6e530a899ef2",
              "image": "https://wger.de/media/exercise-images/822/6a770e5d-cd62-4754-a18c-eebe2103d7c5.png",
              "is_main": false,
              "style": "4",
              "license": 2,
              "license_title": "",
              "license_object_url": "",
              "license_author": "cshep442",
              "license_author_url": "",
              "license_derivative_source_url": "",
              "author_history": [
                "cshep442"
              ]
            }
          ],
          "exercises": [
            {
              "id": 1078,
              "uuid": "e99166c7-caf9-44fc-a8b0-9249a2ebb6b5",
              "name": "Cable Rear Delt Fly",
              "exercise_base": 822,
              "description": "<p style=\"\">The reverse cable fly, also known as the cable rear delt fly, is a deltoid muscle strengthening and definition exercise. It’s one of the best isolation exercises for your back and posterior deltoid.This workout targets your posterior (back) deltoids while using a range of upper body muscles.</p><p style=\"\"></p><ol><li>Adjust the weight and the pulleys to the right height. You should be able to see the pulleys because they should be above your head.</li><li>With your right hand, grab the left pulley, and with your left hand, grab the right pulley, crossing them in front of you. This is where you’ll begin your journey.</li><li>Start the movement by moving your arms back and forth while keeping your arms straight.</li><li>Pause at the finish of the move for a brief moment before returning the handles to their starting positions.</li></ol><p></p>",
              "created": "2023-08-06T10:17:17.349574+02:00",
              "language": 2,
              "aliases": [],
              "notes": [],
              "license": 2,
              "license_title": "",
              "license_object_url": "",
              "license_author": "cshep442",
              "license_author_url": "",
              "license_derivative_source_url": "",
              "author_history": [
                "cshep442"
              ]
            }
          ],
          "variations": null,
          "videos": [],
          "author_history": [
            "cshep442"
          ],
          "total_authors_history": [
            "cshep442"
          ]
        },
        {
          "id": 828,
          "uuid": "70c99a4e-3340-4993-a7f1-2d2709dada1a",
          "created": "2023-08-06T10:17:17.422900+02:00",
          "last_update": "2024-01-17T11:21:06.404120+01:00",
          "last_update_global": "2024-01-17T11:21:06.409113+01:00",
          "category": {
            "id": 12,
            "name": "Back"
          },
          "muscles": [
            {
              "id": 2,
              "name": "Anterior deltoid",
              "name_en": "Shoulders",
              "is_front": true,
              "image_url_main": "/static/images/muscles/main/muscle-2.svg",
              "image_url_secondary": "/static/images/muscles/secondary/muscle-2.svg"
            },
            {
              "id": 9,
              "name": "Trapezius",
              "name_en": "",
              "is_front": false,
              "image_url_main": "/static/images/muscles/main/muscle-9.svg",
              "image_url_secondary": "/static/images/muscles/secondary/muscle-9.svg"
            }
          ],
          "muscles_secondary": [],
          "equipment": [
            {
              "id": 3,
              "name": "Dumbbell"
            }
          ],
          "license": {
            "id": 2,
            "full_name": "Creative Commons Attribution Share Alike 4",
            "short_name": "CC-BY-SA 4",
            "url": "https://creativecommons.org/licenses/by-sa/4.0/deed.en"
          },
          "license_author": "cshep442",
          "images": [
            {
              "id": 214,
              "uuid": "2e959dab-f39b-4c7c-9063-eb43064ab5eb",
              "exercise_base": 828,
              "exercise_base_uuid": "70c99a4e-3340-4993-a7f1-2d2709dada1a",
              "image": "https://wger.de/media/exercise-images/828/2e959dab-f39b-4c7c-9063-eb43064ab5eb.png",
              "is_main": true,
              "style": "4",
              "license": 2,
              "license_title": "",
              "license_object_url": "",
              "license_author": "cshep442",
              "license_author_url": "",
              "license_derivative_source_url": "",
              "author_history": [
                "cshep442"
              ]
            },
            {
              "id": 215,
              "uuid": "abfc7700-fadf-4f2d-ac84-e045e590a2fe",
              "exercise_base": 828,
              "exercise_base_uuid": "70c99a4e-3340-4993-a7f1-2d2709dada1a",
              "image": "https://wger.de/media/exercise-images/828/abfc7700-fadf-4f2d-ac84-e045e590a2fe.png",
              "is_main": false,
              "style": "4",
              "license": 2,
              "license_title": "",
              "license_object_url": "",
              "license_author": "cshep442",
              "license_author_url": "",
              "license_derivative_source_url": "",
              "author_history": [
                "cshep442"
              ]
            }
          ],
          "exercises": [
            {
              "id": 1080,
              "uuid": "ee2199f8-f649-4147-8a27-d2fd45497a10",
              "name": "Incline Bench Reverse Fly - Hello",
              "exercise_base": 828,
              "description": "The incline dumbbell reverse fly is an upper-body exercise targeting the posterior or rear deltoids, as well as the postural muscles of the upper back. Because it targets such small muscles, this exercise is usually performed with light weight for high reps, such as 10-15 reps per set or more.",
              "created": "2023-08-06T10:17:17.349574+02:00",
              "language": 2,
              "aliases": [],
              "notes": [],
              "license": 2,
              "license_title": "",
              "license_object_url": "",
              "license_author": "cshep442",
              "license_author_url": "",
              "license_derivative_source_url": "",
              "author_history": [
                "cshep442"
              ]
            }
          ],
          "variations": null,
          "videos": [],
          "author_history": [
            "cshep442"
          ],
          "total_authors_history": [
            "cshep442"
          ]
        },
        {
          "id": 849,
          "uuid": "fb0c8c53-27ec-4aac-ab6e-403b7d7f250b",
          "created": "2023-08-06T10:17:17.422900+02:00",
          "last_update": "2024-01-17T11:21:06.724657+01:00",
          "last_update_global": "2024-01-17T11:21:14.996876+01:00",
          "category": {
            "id": 9,
            "name": "Legs"
          },
          "muscles": [
            {
              "id": 10,
              "name": "Quadriceps femoris",
              "name_en": "Quads",
              "is_front": true,
              "image_url_main": "/static/images/muscles/main/muscle-10.svg",
              "image_url_secondary": "/static/images/muscles/secondary/muscle-10.svg"
            }
          ],
          "muscles_secondary": [
            {
              "id": 11,
              "name": "Biceps femoris",
              "name_en": "Hamstrings",
              "is_front": false,
              "image_url_main": "/static/images/muscles/main/muscle-11.svg",
              "image_url_secondary": "/static/images/muscles/secondary/muscle-11.svg"
            }
          ],
          "equipment": [
            {
              "id": 1,
              "name": "Barbell"
            }
          ],
          "license": {
            "id": 2,
            "full_name": "Creative Commons Attribution Share Alike 4",
            "short_name": "CC-BY-SA 4",
            "url": "https://creativecommons.org/licenses/by-sa/4.0/deed.en"
          },
          "license_author": "enros7500",
          "images": [
            {
              "id": 228,
              "uuid": "783d980c-af07-4ac0-a525-6dc8c426a204",
              "exercise_base": 849,
              "exercise_base_uuid": "fb0c8c53-27ec-4aac-ab6e-403b7d7f250b",
              "image": "https://wger.de/media/exercise-images/849/783d980c-af07-4ac0-a525-6dc8c426a204.gif",
              "is_main": true,
              "style": "4",
              "license": 2,
              "license_title": "",
              "license_object_url": "",
              "license_author": "enros7500",
              "license_author_url": "",
              "license_derivative_source_url": "",
              "author_history": [
                "enros7500"
              ]
            },
            {
              "id": 229,
              "uuid": "30b2631d-d7ec-415c-800b-7eb082314c0a",
              "exercise_base": 849,
              "exercise_base_uuid": "fb0c8c53-27ec-4aac-ab6e-403b7d7f250b",
              "image": "https://wger.de/media/exercise-images/849/30b2631d-d7ec-415c-800b-7eb082314c0a.gif",
              "is_main": false,
              "style": "4",
              "license": 2,
              "license_title": "",
              "license_object_url": "",
              "license_author": "enros7500",
              "license_author_url": "",
              "license_derivative_source_url": "",
              "author_history": [
                "enros7500"
              ]
            }
          ],
          "exercises": [
            {
              "id": 1101,
              "uuid": "257fdd82-bd43-4a29-81e8-c1d6ec62987d",
              "name": "Barbell Squat",
              "exercise_base": 849,
              "description": "Control the descent, go down in 2 seconds and go up as explosively as you can.\nIt is very important that you do hip mobility before you start training, to improve depth.\nForget about the weight, go down as far as you can, without lifting your heels off the ground and go up.\nA good technique will generate more hypertrophy than a lot of weight without a correct ROM.",
              "created": "2023-08-06T10:17:17.349574+02:00",
              "language": 2,
              "aliases": [],
              "notes": [],
              "license": 2,
              "license_title": "",
              "license_object_url": "",
              "license_author": "enros7500",
              "license_author_url": "",
              "license_derivative_source_url": "",
              "author_history": [
                "enros7500"
              ]
            },
            {
              "id": 1103,
              "uuid": "7fbcb14c-9425-4308-a2e6-66feecfeadaa",
              "name": "Squat con barra",
              "exercise_base": 849,
              "description": "Controla la bajada, baja en 2 segundos y sube lo más explosivo que puedas.\nEs muy importante que hagas movilidad de cadera antes de empezar a entrenar, para mejorar la profundidad.\nOlvidate del peso, baja todo lo que puedas, sin levantar los talones del suelo y sube par arriba.\nUna buena técnica va a generarte más hipertrofia que mucho peso sin un ROM correcto.",
              "created": "2023-08-06T10:17:17.349574+02:00",
              "language": 4,
              "aliases": [
                {
                  "id": 515,
                  "uuid": "f2d89052-f20e-44c7-b052-792fadb2a258",
                  "alias": "Sentadilla con barra"
                }
              ],
              "notes": [],
              "license": 2,
              "license_title": "",
              "license_object_url": "",
              "license_author": "enros7500",
              "license_author_url": "",
              "license_derivative_source_url": "",
              "author_history": [
                "enros7500"
              ]
            },
            {
              "id": 1168,
              "uuid": "bf837018-4b7d-4840-b8ee-d3b63017b7bc",
              "name": "Squat con bilanciere",
              "exercise_base": 849,
              "description": "Controlla la discesa, scendi in 2 secondi e risali nel modo più esplosivo possibile. È molto importante eseguire la mobilità dell'anca prima di iniziare l'allenamento, per migliorare la profondità. Dimentica il peso, scendi più che puoi, senza sollevare i talloni da terra e sali. Una buona tecnica genererà più ipertrofia di molto peso senza un corretto ROM.",
              "created": "2023-08-06T10:17:17.349574+02:00",
              "language": 13,
              "aliases": [],
              "notes": [],
              "license": 2,
              "license_title": "",
              "license_object_url": "",
              "license_author": "enros7500",
              "license_author_url": "",
              "license_derivative_source_url": "",
              "author_history": [
                "rlamarca",
                "enros7500"
              ]
            },
            {
              "id": 2155,
              "uuid": "ff1cf22c-35a4-429f-9a5c-3d4e30844eef",
              "name": "Приседания со штангой",
              "exercise_base": 849,
              "description": "Упражнение приседания играет ключевую роль для развития нижней части тела, при этом его эффективность и безопасность зависят от техники выполнения. Это включает в себя правильную постановку ног, глубину приседания, положение колен и носков, а также место укладки штанги. Новичкам рекомендуется следовать классической технике, а не лифтёрской, если они не занимаются пауэрлифтингом.\n\nСтойка: Станьте прямо, разместив ноги на ширине плеч, носки слегка развернуты в стороны.\n\nЗахват штанги: Подойдите к штанге, поместив ее на верхнюю часть спины (не слишком низко). Захватите штангу обеими руками.\n\nНачальное положение: Отведите ноги назад и встаньте в полное вертикальное положение, удерживая штангу на плечах.\n\nВыполнение: Начинайте опускаться, отодвигая таз назад, как будто садитесь на стул, пока бедра не станут параллельны полу или чуть ниже. Убедитесь, что ваши колени направлены в том же направлении, что и носки, и не выходят за линию стопы.\n\nВозврат в исходное положение: Нажимая на пятки, поднимитесь обратно в вертикальное положение.\n\nПовторите: Выполните рекомендованное количество повторений.\n\nПримечание: Если вы испытываете трудности в удержании пяток на полу во время приседания, используйте небольшие подставки под пятки. При правильной технике и выполнении приседаний, особенно глубоких, ягодицы активно включаются в работу.",
              "created": "2023-10-14T16:52:00.698617+02:00",
              "language": 5,
              "aliases": [],
              "notes": [],
              "license": 2,
              "license_title": "",
              "license_object_url": "",
              "license_author": "enros7500",
              "license_author_url": "",
              "license_derivative_source_url": "",
              "author_history": [
                "enleks",
                "enros7500"
              ]
            }
          ],
          "variations": null,
          "videos": [],
          "author_history": [
            "enros7500"
          ],
          "total_authors_history": [
            "rlamarca",
            "enleks",
            "enros7500"
          ]
        },
        {
          "id": 907,
          "uuid": "ed00a43f-f761-41f2-94d4-056120bc5f6d",
          "created": "2023-08-06T10:17:17.422900+02:00",
          "last_update": "2024-01-17T11:21:17.691584+01:00",
          "last_update_global": "2024-01-17T11:21:17.723540+01:00",
          "category": {
            "id": 13,
            "name": "Shoulders"
          },
          "muscles": [
            {
              "id": 2,
              "name": "Anterior deltoid",
              "name_en": "Shoulders",
              "is_front": true,
              "image_url_main": "/static/images/muscles/main/muscle-2.svg",
              "image_url_secondary": "/static/images/muscles/secondary/muscle-2.svg"
            },
            {
              "id": 5,
              "name": "Triceps brachii",
              "name_en": "Triceps",
              "is_front": false,
              "image_url_main": "/static/images/muscles/main/muscle-5.svg",
              "image_url_secondary": "/static/images/muscles/secondary/muscle-5.svg"
            }
          ],
          "muscles_secondary": [
            {
              "id": 4,
              "name": "Pectoralis major",
              "name_en": "Chest",
              "is_front": true,
              "image_url_main": "/static/images/muscles/main/muscle-4.svg",
              "image_url_secondary": "/static/images/muscles/secondary/muscle-4.svg"
            }
          ],
          "equipment": [],
          "license": {
            "id": 2,
            "full_name": "Creative Commons Attribution Share Alike 4",
            "short_name": "CC-BY-SA 4",
            "url": "https://creativecommons.org/licenses/by-sa/4.0/deed.en"
          },
          "license_author": "karly",
          "images": [],
          "exercises": [
            {
              "id": 2027,
              "uuid": "f5e7f97f-a33c-4f52-9316-8059f1c145dc",
              "name": "Flexiones a pino",
              "exercise_base": 907,
              "description": "Flexiones mientras se hace el pino. Requiere mucha habilidad y fuerza",
              "created": "2023-08-06T10:17:17.349574+02:00",
              "language": 4,
              "aliases": [],
              "notes": [],
              "license": 2,
              "license_title": "",
              "license_object_url": "",
              "license_author": "karly",
              "license_author_url": "",
              "license_derivative_source_url": "",
              "author_history": [
                "karly",
                "Imobard"
              ]
            },
            {
              "id": 1163,
              "uuid": "58107eea-4dcf-42e6-90a8-c8d11735f155",
              "name": "Handstand Push Up",
              "exercise_base": 907,
              "description": "Handstands Push Up which demand high level of skill",
              "created": "2023-08-06T10:17:17.349574+02:00",
              "language": 2,
              "aliases": [],
              "notes": [
                {
                  "id": 294,
                  "uuid": "8cba38fb-70fa-4473-a92d-6cc46006f090",
                  "exercise": 1163,
                  "comment": "Keep your body straight"
                }
              ],
              "license": 2,
              "license_title": "",
              "license_object_url": "",
              "license_author": "karly",
              "license_author_url": "",
              "license_derivative_source_url": "",
              "author_history": [
                "karly"
              ]
            }
          ],
          "variations": null,
          "videos": [],
          "author_history": [
            "karly"
          ],
          "total_authors_history": [
            "karly",
            "Imobard"
          ]
        },
        {
          "id": 908,
          "uuid": "89c3d614-e841-4c04-bee8-6761567e4b7c",
          "created": "2023-08-06T10:17:17.422900+02:00",
          "last_update": "2024-01-17T11:21:17.801534+01:00",
          "last_update_global": "2024-01-17T11:21:17.858050+01:00",
          "category": {
            "id": 15,
            "name": "Cardio"
          },
          "muscles": [],
          "muscles_secondary": [],
          "equipment": [],
          "license": {
            "id": 2,
            "full_name": "Creative Commons Attribution Share Alike 4",
            "short_name": "CC-BY-SA 4",
            "url": "https://creativecommons.org/licenses/by-sa/4.0/deed.en"
          },
          "license_author": "karly",
          "images": [],
          "exercises": [
            {
              "id": 2041,
              "uuid": "42f6526e-34aa-4945-80e4-421a1cd7401a",
              "name": "Corsa in zona 2",
              "exercise_base": 908,
              "description": "Zona due Cardio per la resistenza, dovresti essere in grado di parlare mentre corri",
              "created": "2023-08-06T10:17:17.349574+02:00",
              "language": 13,
              "aliases": [],
              "notes": [],
              "license": 2,
              "license_title": "",
              "license_object_url": "",
              "license_author": "karly",
              "license_author_url": "",
              "license_derivative_source_url": "",
              "author_history": [
                "karly",
                "clafal"
              ]
            },
            {
              "id": 1187,
              "uuid": "d435670f-e539-43fd-95d0-556acbb0ad65",
              "name": "Zone 2 Running",
              "exercise_base": 908,
              "description": "Zone two Cardio for endurance, you should be able to speak while running",
              "created": "2023-08-06T10:17:17.349574+02:00",
              "language": 2,
              "aliases": [],
              "notes": [],
              "license": 2,
              "license_title": "",
              "license_object_url": "",
              "license_author": "karly",
              "license_author_url": "",
              "license_derivative_source_url": "",
              "author_history": [
                "karly"
              ]
            }
          ],
          "variations": null,
          "videos": [],
          "author_history": [
            "karly"
          ],
          "total_authors_history": [
            "karly",
            "clafal"
          ]
        },
        {
          "id": 923,
          "uuid": "dab7400b-e86e-4224-bcea-4a915dc928e0",
          "created": "2023-08-06T10:17:17.422900+02:00",
          "last_update": "2024-01-17T11:21:17.916872+01:00",
          "last_update_global": "2024-01-17T11:21:17.921668+01:00",
          "category": {
            "id": 12,
            "name": "Back"
          },
          "muscles": [
            {
              "id": 12,
              "name": "Latissimus dorsi",
              "name_en": "Lats",
              "is_front": false,
              "image_url_main": "/static/images/muscles/main/muscle-12.svg",
              "image_url_secondary": "/static/images/muscles/secondary/muscle-12.svg"
            }
          ],
          "muscles_secondary": [],
          "equipment": [
            {
              "id": 3,
              "name": "Dumbbell"
            }
          ],
          "license": {
            "id": 2,
            "full_name": "Creative Commons Attribution Share Alike 4",
            "short_name": "CC-BY-SA 4",
            "url": "https://creativecommons.org/licenses/by-sa/4.0/deed.en"
          },
          "license_author": "novadani",
          "images": [],
          "exercises": [
            {
              "id": 1202,
              "uuid": "204795fd-9c36-4198-b9fc-6a3aae0a19bf",
              "name": "LYING DUMBBELL ROW SS SEATED SHRUG",
              "exercise_base": 923,
              "description": "laying on the stomach on a bench with slight angle",
              "created": "2023-08-06T10:17:17.349574+02:00",
              "language": 2,
              "aliases": [],
              "notes": [],
              "license": 2,
              "license_title": "",
              "license_object_url": "",
              "license_author": "novadani",
              "license_author_url": "",
              "license_derivative_source_url": "",
              "author_history": [
                "novadani"
              ]
            }
          ],
          "variations": null,
          "videos": [],
          "author_history": [
            "novadani"
          ],
          "total_authors_history": [
            "novadani"
          ]
        },
        {
          "id": 927,
          "uuid": "e0d9e9ef-09ee-4d26-9504-622093810414",
          "created": "2023-08-06T10:17:17.422900+02:00",
          "last_update": "2024-01-17T11:21:17.944225+01:00",
          "last_update_global": "2024-03-25T13:38:37.963706+01:00",
          "category": {
            "id": 15,
            "name": "Cardio"
          },
          "muscles": [
            {
              "id": 4,
              "name": "Pectoralis major",
              "name_en": "Chest",
              "is_front": true,
              "image_url_main": "/static/images/muscles/main/muscle-4.svg",
              "image_url_secondary": "/static/images/muscles/secondary/muscle-4.svg"
            }
          ],
          "muscles_secondary": [],
          "equipment": [
            {
              "id": 7,
              "name": "none (bodyweight exercise)"
            }
          ],
          "license": {
            "id": 2,
            "full_name": "Creative Commons Attribution Share Alike 4",
            "short_name": "CC-BY-SA 4",
            "url": "https://creativecommons.org/licenses/by-sa/4.0/deed.en"
          },
          "license_author": null,
          "images": [
            {
              "id": 248,
              "uuid": "7b392101-9c47-4693-935e-a88b1887eec5",
              "exercise_base": 927,
              "exercise_base_uuid": "e0d9e9ef-09ee-4d26-9504-622093810414",
              "image": "https://wger.de/media/exercise-images/927/7b392101-9c47-4693-935e-a88b1887eec5.jpg",
              "is_main": true,
              "style": "4",
              "license": 2,
              "license_title": "",
              "license_object_url": "",
              "license_author": null,
              "license_author_url": "",
              "license_derivative_source_url": "",
              "author_history": []
            }
          ],
          "exercises": [
            {
              "id": 1964,
              "uuid": "9251b3a5-fdda-46bb-ae5e-f7d84ab130d5",
              "name": "Croci in sospensione",
              "exercise_base": 927,
              "description": "Esercizio di sospensione con trx per l'allenamento del torace",
              "created": "2023-08-06T10:17:17.349574+02:00",
              "language": 13,
              "aliases": [],
              "notes": [],
              "license": 2,
              "license_title": "",
              "license_object_url": "",
              "license_author": null,
              "license_author_url": "",
              "license_derivative_source_url": "",
              "author_history": [
                "clafal"
              ]
            },
            {
              "id": 1206,
              "uuid": "b2a64542-b93f-4ab5-8562-f8b7de599ff2",
              "name": "Suspended crossess",
              "exercise_base": 927,
              "description": "Suspension exercise with trx for chest training",
              "created": "2023-08-06T10:17:17.349574+02:00",
              "language": 2,
              "aliases": [
                {
                  "id": 516,
                  "uuid": "1ba465e2-80a1-4273-8b3b-7fc4a991ef9e",
                  "alias": "croci"
                },
                {
                  "id": 517,
                  "uuid": "768b936f-834a-4b44-9303-268296542929",
                  "alias": "sospensione"
                },
                {
                  "id": 518,
                  "uuid": "608ba427-c917-4a4b-97ca-4a8c6f42ef3a",
                  "alias": "trx"
                }
              ],
              "notes": [],
              "license": 2,
              "license_title": "",
              "license_object_url": "",
              "license_author": null,
              "license_author_url": "",
              "license_derivative_source_url": "",
              "author_history": []
            },
            {
              "id": 2215,
              "uuid": "c2e98e89-d8e4-47bf-8105-0626c6282022",
              "name": "flexiones en TRX",
              "exercise_base": 927,
              "description": "Las&nbsp;flexiones de brazos&nbsp;en TRX añaden un componente de inestabilidad que hará que tus&nbsp;hombros y tus pectorales trabajen de manera diferente. Puedes hacer que el ejercicio sea más o menos intenso colocando tu cuerpo más paralelo o menos al suelo. Evita que tus brazos rocen con las cuerdas porque puede que no lo notes mientras entrenas, pero podrás tener rozaduras y moratones después.",
              "created": "2024-03-25T13:38:37.963685+01:00",
              "language": 4,
              "aliases": [],
              "notes": [],
              "license": 2,
              "license_title": "",
              "license_object_url": "",
              "license_author": "cynomops",
              "license_author_url": "",
              "license_derivative_source_url": "",
              "author_history": [
                "cynomops"
              ]
            }
          ],
          "variations": null,
          "videos": [],
          "author_history": [],
          "total_authors_history": [
            "cynomops",
            "clafal"
          ]
        },
        {
          "id": 958,
          "uuid": "596b9d2d-0f01-41a0-97e1-1839ffdb824d",
          "created": "2023-08-06T10:17:17.422900+02:00",
          "last_update": "2024-01-17T11:21:18.037100+01:00",
          "last_update_global": "2024-01-17T11:21:18.149992+01:00",
          "category": {
            "id": 10,
            "name": "Abs"
          },
          "muscles": [
            {
              "id": 1,
              "name": "Biceps brachii",
              "name_en": "Biceps",
              "is_front": true,
              "image_url_main": "/static/images/muscles/main/muscle-1.svg",
              "image_url_secondary": "/static/images/muscles/secondary/muscle-1.svg"
            }
          ],
          "muscles_secondary": [],
          "equipment": [
            {
              "id": 7,
              "name": "none (bodyweight exercise)"
            }
          ],
          "license": {
            "id": 2,
            "full_name": "Creative Commons Attribution Share Alike 4",
            "short_name": "CC-BY-SA 4",
            "url": "https://creativecommons.org/licenses/by-sa/4.0/deed.en"
          },
          "license_author": "clafal",
          "images": [
            {
              "id": 429,
              "uuid": "947ac249-475d-44ed-bed3-8dc433374f59",
              "exercise_base": 958,
              "exercise_base_uuid": "596b9d2d-0f01-41a0-97e1-1839ffdb824d",
              "image": "https://wger.de/media/exercise-images/958/947ac249-475d-44ed-bed3-8dc433374f59.png",
              "is_main": true,
              "style": "4",
              "license": 2,
              "license_title": "",
              "license_object_url": "",
              "license_author": "cynomops",
              "license_author_url": "",
              "license_derivative_source_url": "",
              "author_history": [
                "cynomops"
              ]
            },
            {
              "id": 430,
              "uuid": "95f2bbc4-2f95-476d-a9b8-81b333fe2ef5",
              "exercise_base": 958,
              "exercise_base_uuid": "596b9d2d-0f01-41a0-97e1-1839ffdb824d",
              "image": "https://wger.de/media/exercise-images/958/95f2bbc4-2f95-476d-a9b8-81b333fe2ef5.png",
              "is_main": false,
              "style": "4",
              "license": 2,
              "license_title": "",
              "license_object_url": "",
              "license_author": "cynomops",
              "license_author_url": "",
              "license_derivative_source_url": "",
              "author_history": [
                "cynomops"
              ]
            },
            {
              "id": 431,
              "uuid": "dfad24f7-3f6f-497c-8436-7dfd909bca3f",
              "exercise_base": 958,
              "exercise_base_uuid": "596b9d2d-0f01-41a0-97e1-1839ffdb824d",
              "image": "https://wger.de/media/exercise-images/958/dfad24f7-3f6f-497c-8436-7dfd909bca3f.png",
              "is_main": false,
              "style": "4",
              "license": 2,
              "license_title": "",
              "license_object_url": "",
              "license_author": "cynomops",
              "license_author_url": "",
              "license_derivative_source_url": "",
              "author_history": [
                "cynomops"
              ]
            }
          ],
          "exercises": [
            {
              "id": 2158,
              "uuid": "831f44bf-f69a-4ef2-a5ed-3c5148c318ba",
              "name": "Biceps con TRX",
              "exercise_base": 958,
              "description": "músculos implicados: bíceps Agarre las asas de las correas TRX, incline el cuerpo hacia atrás, brazos y piernas extendidos, cuerpo posicionado en una sola línea. (no es de abdominales, es de brazos)",
              "created": "2023-11-10T16:03:05.317838+01:00",
              "language": 4,
              "aliases": [],
              "notes": [],
              "license": 2,
              "license_title": "",
              "license_object_url": "",
              "license_author": "clafal",
              "license_author_url": "",
              "license_derivative_source_url": "",
              "author_history": [
                "cynomops",
                "clafal"
              ]
            },
            {
              "id": 1241,
              "uuid": "20ae9f13-fa46-4965-9cf8-6ed627a31d60",
              "name": "Bicipiti al trx",
              "exercise_base": 958,
              "description": "muscoli coinvolti: bicipitiAfferrare le maniglie delle cinghie TRX, inclinare il corpo all’indietro.Braccia e gambe distese, corpo disposto su un’unica linea.",
              "created": "2023-08-06T10:17:17.349574+02:00",
              "language": 13,
              "aliases": [],
              "notes": [],
              "license": 2,
              "license_title": "",
              "license_object_url": "",
              "license_author": "clafal",
              "license_author_url": "",
              "license_derivative_source_url": "",
              "author_history": [
                "clafal"
              ]
            },
            {
              "id": 1238,
              "uuid": "14c7bcde-9182-4473-8e87-b510b7ae324c",
              "name": "Bicipiti con trx",
              "exercise_base": 958,
              "description": "muscoli coinvolti: bicipitiAfferrare le maniglie delle cinghie TRX, inclinare il corpo all’indietro.Braccia e gambe distese, corpo disposto su un’unica linea.",
              "created": "2023-08-06T10:17:17.349574+02:00",
              "language": 2,
              "aliases": [],
              "notes": [],
              "license": 2,
              "license_title": "",
              "license_object_url": "",
              "license_author": "clafal",
              "license_author_url": "",
              "license_derivative_source_url": "",
              "author_history": [
                "clafal"
              ]
            }
          ],
          "variations": null,
          "videos": [],
          "author_history": [
            "clafal"
          ],
          "total_authors_history": [
            "cynomops",
            "clafal"
          ]
        },
        {
          "id": 960,
          "uuid": "d813ef7c-b10a-4c5c-ba55-6b9518e7ff4c",
          "created": "2023-08-06T10:17:17.422900+02:00",
          "last_update": "2024-01-17T11:21:18.221783+01:00",
          "last_update_global": "2024-04-03T17:24:00.736054+02:00",
          "category": {
            "id": 10,
            "name": "Abs"
          },
          "muscles": [
            {
              "id": 2,
              "name": "Anterior deltoid",
              "name_en": "Shoulders",
              "is_front": true,
              "image_url_main": "/static/images/muscles/main/muscle-2.svg",
              "image_url_secondary": "/static/images/muscles/secondary/muscle-2.svg"
            },
            {
              "id": 8,
              "name": "Gluteus maximus",
              "name_en": "Glutes",
              "is_front": false,
              "image_url_main": "/static/images/muscles/main/muscle-8.svg",
              "image_url_secondary": "/static/images/muscles/secondary/muscle-8.svg"
            }
          ],
          "muscles_secondary": [
            {
              "id": 10,
              "name": "Quadriceps femoris",
              "name_en": "Quads",
              "is_front": true,
              "image_url_main": "/static/images/muscles/main/muscle-10.svg",
              "image_url_secondary": "/static/images/muscles/secondary/muscle-10.svg"
            },
            {
              "id": 6,
              "name": "Rectus abdominis",
              "name_en": "Abs",
              "is_front": true,
              "image_url_main": "/static/images/muscles/main/muscle-6.svg",
              "image_url_secondary": "/static/images/muscles/secondary/muscle-6.svg"
            },
            {
              "id": 9,
              "name": "Trapezius",
              "name_en": "",
              "is_front": false,
              "image_url_main": "/static/images/muscles/main/muscle-9.svg",
              "image_url_secondary": "/static/images/muscles/secondary/muscle-9.svg"
            }
          ],
          "equipment": [
            {
              "id": 10,
              "name": "Kettlebell"
            }
          ],
          "license": {
            "id": 2,
            "full_name": "Creative Commons Attribution Share Alike 4",
            "short_name": "CC-BY-SA 4",
            "url": "https://creativecommons.org/licenses/by-sa/4.0/deed.en"
          },
          "license_author": "clafal",
          "images": [],
          "exercises": [
            {
              "id": 1253,
              "uuid": "99ab7599-c61b-4d97-bf3f-83825d1eafee",
              "name": "Kettlebell swing",
              "exercise_base": 960,
              "description": "Le oscillazioni con kettlebell sono un allenamento per tutto il corpo, colpiscono principalmente i muscoli lungo la catena posteriore (parte posteriore del corpo). I principali muscoli utilizzati sono i glutei, i muscoli posteriori della coscia, gli erettori spinali e i muscoli della parte superiore della schiena.",
              "created": "2023-08-06T10:17:17.349574+02:00",
              "language": 13,
              "aliases": [],
              "notes": [],
              "license": 2,
              "license_title": "",
              "license_object_url": "",
              "license_author": "clafal",
              "license_author_url": "",
              "license_derivative_source_url": "",
              "author_history": [
                "clafal"
              ]
            },
            {
              "id": 1252,
              "uuid": "ca7a14d8-ca6b-4007-8fae-9ebeba53c773",
              "name": "kettlebell swing",
              "exercise_base": 960,
              "description": "While kettlebell swings are a full-body workout, they mostly target the muscles along the posterior chain (back of the body). The main muscles used are the glutes, hamstrings, spinal erectors, and muscles of the upper back.",
              "created": "2023-08-06T10:17:17.349574+02:00",
              "language": 2,
              "aliases": [],
              "notes": [],
              "license": 2,
              "license_title": "",
              "license_object_url": "",
              "license_author": "clafal",
              "license_author_url": "",
              "license_derivative_source_url": "",
              "author_history": [
                "clafal"
              ]
            }
          ],
          "variations": null,
          "videos": [],
          "author_history": [
            "clafal"
          ],
          "total_authors_history": [
            "clafal"
          ]
        },
        {
          "id": 961,
          "uuid": "6c8b0c67-68af-4473-907e-31fb1e48430c",
          "created": "2023-08-06T10:17:17.422900+02:00",
          "last_update": "2024-01-17T11:21:18.343358+01:00",
          "last_update_global": "2024-01-17T11:21:18.352064+01:00",
          "category": {
            "id": 15,
            "name": "Cardio"
          },
          "muscles": [],
          "muscles_secondary": [],
          "equipment": [],
          "license": {
            "id": 2,
            "full_name": "Creative Commons Attribution Share Alike 4",
            "short_name": "CC-BY-SA 4",
            "url": "https://creativecommons.org/licenses/by-sa/4.0/deed.en"
          },
          "license_author": "abuono",
          "images": [],
          "exercises": [
            {
              "id": 1255,
              "uuid": "e92206ab-ee30-4a89-ac50-947a962e1c76",
              "name": "Swimming 50m sprints",
              "exercise_base": 961,
              "description": "50m swimming sprints at 1min",
              "created": "2023-08-06T10:17:17.349574+02:00",
              "language": 2,
              "aliases": [],
              "notes": [],
              "license": 2,
              "license_title": "",
              "license_object_url": "",
              "license_author": "abuono",
              "license_author_url": "",
              "license_derivative_source_url": "",
              "author_history": [
                "abuono"
              ]
            }
          ],
          "variations": null,
          "videos": [],
          "author_history": [
            "abuono"
          ],
          "total_authors_history": [
            "abuono"
          ]
        },
        {
          "id": 962,
          "uuid": "95a300de-2ad8-492e-9364-13766d9e7618",
          "created": "2023-08-06T10:17:17.422900+02:00",
          "last_update": "2024-01-17T11:21:18.394432+01:00",
          "last_update_global": "2024-01-17T11:21:18.496038+01:00",
          "category": {
            "id": 15,
            "name": "Cardio"
          },
          "muscles": [
            {
              "id": 8,
              "name": "Gluteus maximus",
              "name_en": "Glutes",
              "is_front": false,
              "image_url_main": "/static/images/muscles/main/muscle-8.svg",
              "image_url_secondary": "/static/images/muscles/secondary/muscle-8.svg"
            },
            {
              "id": 10,
              "name": "Quadriceps femoris",
              "name_en": "Quads",
              "is_front": true,
              "image_url_main": "/static/images/muscles/main/muscle-10.svg",
              "image_url_secondary": "/static/images/muscles/secondary/muscle-10.svg"
            },
            {
              "id": 9,
              "name": "Trapezius",
              "name_en": "",
              "is_front": false,
              "image_url_main": "/static/images/muscles/main/muscle-9.svg",
              "image_url_secondary": "/static/images/muscles/secondary/muscle-9.svg"
            }
          ],
          "muscles_secondary": [
            {
              "id": 1,
              "name": "Biceps brachii",
              "name_en": "Biceps",
              "is_front": true,
              "image_url_main": "/static/images/muscles/main/muscle-1.svg",
              "image_url_secondary": "/static/images/muscles/secondary/muscle-1.svg"
            },
            {
              "id": 6,
              "name": "Rectus abdominis",
              "name_en": "Abs",
              "is_front": true,
              "image_url_main": "/static/images/muscles/main/muscle-6.svg",
              "image_url_secondary": "/static/images/muscles/secondary/muscle-6.svg"
            },
            {
              "id": 5,
              "name": "Triceps brachii",
              "name_en": "Triceps",
              "is_front": false,
              "image_url_main": "/static/images/muscles/main/muscle-5.svg",
              "image_url_secondary": "/static/images/muscles/secondary/muscle-5.svg"
            }
          ],
          "equipment": [
            {
              "id": 7,
              "name": "none (bodyweight exercise)"
            }
          ],
          "license": {
            "id": 2,
            "full_name": "Creative Commons Attribution Share Alike 4",
            "short_name": "CC-BY-SA 4",
            "url": "https://creativecommons.org/licenses/by-sa/4.0/deed.en"
          },
          "license_author": "clafal",
          "images": [],
          "exercises": [
            {
              "id": 1257,
              "uuid": "7e2bc88a-f00f-4bfb-856e-78432b70d8ba",
              "name": "Elliptical",
              "exercise_base": 962,
              "description": "It improves muscle toning, strengthens the leg muscles (quads, glutes, calves), helps vascularisation and increases resistance. The elliptical is also very useful if you aim to lose weight.",
              "created": "2023-08-06T10:17:17.349574+02:00",
              "language": 2,
              "aliases": [],
              "notes": [],
              "license": 2,
              "license_title": "",
              "license_object_url": "",
              "license_author": "clafal",
              "license_author_url": "",
              "license_derivative_source_url": "",
              "author_history": [
                "clafal"
              ]
            },
            {
              "id": 1258,
              "uuid": "2520dd44-9d3a-4975-b668-c4b754ec5bcd",
              "name": "Ellittica",
              "exercise_base": 962,
              "description": "Migliora la tonificazione muscolare, potenzia i muscoli delle gambe (quadricipiti, glutei, polpacci), aiuta la vascolarizzazione e aumenta la resistenza. L'ellittica è inoltre molto utile se si punta al dimagrimento.",
              "created": "2023-08-06T10:17:17.349574+02:00",
              "language": 13,
              "aliases": [],
              "notes": [],
              "license": 2,
              "license_title": "",
              "license_object_url": "",
              "license_author": "clafal",
              "license_author_url": "",
              "license_derivative_source_url": "",
              "author_history": [
                "clafal"
              ]
            }
          ],
          "variations": null,
          "videos": [],
          "author_history": [
            "clafal"
          ],
          "total_authors_history": [
            "clafal"
          ]
        },
        {
          "id": 975,
          "uuid": "d7d4fc16-08cd-4568-87e7-d9e4e2f77393",
          "created": "2023-08-06T10:17:17.422900+02:00",
          "last_update": "2024-01-17T11:21:18.558956+01:00",
          "last_update_global": "2024-01-17T11:21:18.586985+01:00",
          "category": {
            "id": 8,
            "name": "Arms"
          },
          "muscles": [
            {
              "id": 1,
              "name": "Biceps brachii",
              "name_en": "Biceps",
              "is_front": true,
              "image_url_main": "/static/images/muscles/main/muscle-1.svg",
              "image_url_secondary": "/static/images/muscles/secondary/muscle-1.svg"
            }
          ],
          "muscles_secondary": [],
          "equipment": [
            {
              "id": 10,
              "name": "Kettlebell"
            }
          ],
          "license": {
            "id": 2,
            "full_name": "Creative Commons Attribution Share Alike 4",
            "short_name": "CC-BY-SA 4",
            "url": "https://creativecommons.org/licenses/by-sa/4.0/deed.en"
          },
          "license_author": "clafal",
          "images": [],
          "exercises": [
            {
              "id": 1284,
              "uuid": "50de07b7-3b27-4ff7-acae-0a5e6d56f8d9",
              "name": "Curl con kettlebell una sola mano",
              "exercise_base": 975,
              "description": "In piedi con il kettlebell in una mano e piega il gomito, parti da una posizione completamente distesa fino a quando la mano raggiunge l'altezza delle spalle. Per eseguire il movimento in modo corretto cerca di non spingere con la schiena o con il corpo.",
              "created": "2023-08-06T10:17:17.349574+02:00",
              "language": 13,
              "aliases": [],
              "notes": [],
              "license": 2,
              "license_title": "",
              "license_object_url": "",
              "license_author": "clafal",
              "license_author_url": "",
              "license_derivative_source_url": "",
              "author_history": [
                "clafal"
              ]
            },
            {
              "id": 1283,
              "uuid": "03888fad-eeff-4b01-ac68-182269658a07",
              "name": "one-handed kettlebell curls",
              "exercise_base": 975,
              "description": "Standing with the kettlebell in one hand and bent at the elbow, start from a fully extended position until your hand reaches shoulder height. To perform the movement correctly, try not to push with your back or body.",
              "created": "2023-08-06T10:17:17.349574+02:00",
              "language": 2,
              "aliases": [],
              "notes": [],
              "license": 2,
              "license_title": "",
              "license_object_url": "",
              "license_author": "clafal",
              "license_author_url": "",
              "license_derivative_source_url": "",
              "author_history": [
                "clafal"
              ]
            }
          ],
          "variations": null,
          "videos": [],
          "author_history": [
            "clafal"
          ],
          "total_authors_history": [
            "clafal"
          ]
        },
        {
          "id": 976,
          "uuid": "346634cf-3896-4c10-bd66-28fb69d02573",
          "created": "2023-08-06T10:17:17.422900+02:00",
          "last_update": "2024-01-17T11:21:18.619698+01:00",
          "last_update_global": "2024-01-17T11:21:18.651605+01:00",
          "category": {
            "id": 10,
            "name": "Abs"
          },
          "muscles": [
            {
              "id": 6,
              "name": "Rectus abdominis",
              "name_en": "Abs",
              "is_front": true,
              "image_url_main": "/static/images/muscles/main/muscle-6.svg",
              "image_url_secondary": "/static/images/muscles/secondary/muscle-6.svg"
            }
          ],
          "muscles_secondary": [],
          "equipment": [
            {
              "id": 7,
              "name": "none (bodyweight exercise)"
            }
          ],
          "license": {
            "id": 2,
            "full_name": "Creative Commons Attribution Share Alike 4",
            "short_name": "CC-BY-SA 4",
            "url": "https://creativecommons.org/licenses/by-sa/4.0/deed.en"
          },
          "license_author": "clafal",
          "images": [],
          "exercises": [
            {
              "id": 1287,
              "uuid": "975905fb-383f-41e3-9a80-f7f3fefe6664",
              "name": "Crunch a libretto con palla medica",
              "exercise_base": 976,
              "description": "L'uso di una palla medica come sovraccarico renderà l'esercizio più pesante.",
              "created": "2023-08-06T10:17:17.349574+02:00",
              "language": 13,
              "aliases": [],
              "notes": [],
              "license": 2,
              "license_title": "",
              "license_object_url": "",
              "license_author": "clafal",
              "license_author_url": "",
              "license_derivative_source_url": "",
              "author_history": [
                "clafal"
              ]
            },
            {
              "id": 1286,
              "uuid": "a1d94c5e-b82d-4698-9013-a10719402286",
              "name": "Medicine ball booklet crunch",
              "exercise_base": 976,
              "description": "Using a medicine ball as an overload will make the exercise heavier.",
              "created": "2023-08-06T10:17:17.349574+02:00",
              "language": 2,
              "aliases": [],
              "notes": [],
              "license": 2,
              "license_title": "",
              "license_object_url": "",
              "license_author": "clafal",
              "license_author_url": "",
              "license_derivative_source_url": "",
              "author_history": [
                "clafal"
              ]
            }
          ],
          "variations": null,
          "videos": [],
          "author_history": [
            "clafal"
          ],
          "total_authors_history": [
            "clafal"
          ]
        }
      ]
    }
""".trimIndent()
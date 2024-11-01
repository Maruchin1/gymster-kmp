package com.maruchin.gymster.data.exercises.model

internal val sampleExercises = listOf(
    Exercise(
        id = 31,
        name = "Axe Hold",
        description = "<p>Grab dumbbells and extend arms to side and hold as long as you can</p>",
        category = ExerciseCategory(id = 8, name = "Arms"),
        images = emptyList()
    ),
    Exercise(
        id = 56,
        name = "Abdominal Stabilization",
        description = "",
        category = ExerciseCategory(id = 10, name = "Abs"),
        images = emptyList()
    ),
    Exercise(
        id = 805,
        name = "Tricep Pushdown on Cable",
        description = "The cable rope push-down is a popular exercise targeting the " +
            "triceps muscles. It's easy to learn and perform, making it a favorite " +
            "for everyone from beginners to advanced lifters. It is usually performed for " +
            "moderate to high reps, such as 8-12 reps or more per set, as part of an " +
            "upper-body or arm-focused workout.",
        category = ExerciseCategory(id = 8, name = "Arms"),
        images = listOf(
            "https://wger.de/media/exercise-images/805/ba006cae-44ca-46a9-bb71-6f5d4fa130e9.png"
        )
    ),
    Exercise(
        id = 981,
        name = "Step-ups",
        description = "<p>Starting position:</p><p>Stand facing a chair.</p><p>Steps:" +
            "</p><ol><li>Step up onto the chair.</li><li>Step off the chair." +
            "</li><li>Repeat.</li></ol>",
        category = ExerciseCategory(id = 9, name = "Legs"),
        images = emptyList()
    ),
    Exercise(
        id = 980,
        name = "commando pull-ups",
        description = "variation of the pull-up exercise, it is performed with a grip of one " +
            "hand supine and one hand prone,&nbsp;do not twist the torso to get back to " +
            "the front, the head passes once to one side, once to the other.",
        category = ExerciseCategory(id = 10, name = "Abs"),
        images = emptyList()
    ),
    Exercise(
        id = 1022,
        name = "Single Arm Plank to Row",
        description = "Start position as row, extend to plank and back. Finish with row and repeat",
        category = ExerciseCategory(id = 12, name = "Back"),
        images = listOf(
            "https://wger.de/media/exercise-images/1022/f74644fa-f43e-46bd-8603-6e3a2ee8ee2d.jpg",
            "https://wger.de/media/exercise-images/1022/eef8fb9d-ae72-4e23-81da-4d62f2734332.jpg"
        )
    ),
    Exercise(
        id = 820,
        name = "Fingerboard 20 mm edge",
        description = "Hang for 10 seconds on a fingerboard with a 20 mm edge",
        category = ExerciseCategory(id = 8, name = "Arms"),
        images = emptyList()
    ),
    Exercise(
        id = 822,
        name = "Cable Rear Delt Fly",
        description = "<p style=\"\">The reverse cable fly, also known as the cable rear delt " +
            "fly, is a deltoid muscle strengthening and definition exercise. It’s one of " +
            "the best isolation exercises for your back and posterior deltoid.This workout " +
            "targets your posterior (back) deltoids while using a range of upper body " +
            "muscles.</p><p style=\"\"></p><ol><li>Adjust the weight and the pulleys to " +
            "the right height. You should be able to see the pulleys because they should " +
            "be above your head.</li><li>With your right hand, grab the left pulley, and " +
            "with your left hand, grab the right pulley, crossing them in front of you. " +
            "This is where you’ll begin your journey.</li><li>Start the movement by moving " +
            "your arms back and forth while keeping your arms straight.</li><li>Pause at the " +
            "finish of the move for a brief moment before returning the handles to their " +
            "starting positions.</li></ol><p></p>",
        category = ExerciseCategory(id = 13, name = "Shoulders"),
        images = listOf(
            "https://wger.de/media/exercise-images/822/74affc0d-03b6-4f33-b5f4-a822a2615f68.png",
            "https://wger.de/media/exercise-images/822/6a770e5d-cd62-4754-a18c-eebe2103d7c5.png"
        )
    ),
    Exercise(
        id = 828,
        name = "Incline Bench Reverse Fly - Hello",
        description = "The incline dumbbell reverse fly is an upper-body exercise targeting " +
            "the posterior or rear deltoids, as well as the postural muscles of the upper " +
            "back. Because it targets such small muscles, this exercise is usually performed " +
            "with light weight for high reps, such as 10-15 reps per set or more.",
        category = ExerciseCategory(id = 12, name = "Back"),
        images = listOf(
            "https://wger.de/media/exercise-images/828/2e959dab-f39b-4c7c-9063-eb43064ab5eb.png",
            "https://wger.de/media/exercise-images/828/abfc7700-fadf-4f2d-ac84-e045e590a2fe.png"
        )
    ),
    Exercise(
        id = 849,
        name = "Barbell Squat",
        description = "Control the descent, go down in 2 seconds and go up as explosively as " +
            "you can.\nIt is very important that you do hip mobility before you start training, " +
            "to improve depth.\nForget about the weight, go down as far as you can, without " +
            "lifting your heels off the ground and go up.\nA good technique will generate more " +
            "hypertrophy than a lot of weight without a correct ROM.",
        category = ExerciseCategory(id = 9, name = "Legs"),
        images = listOf(
            "https://wger.de/media/exercise-images/849/783d980c-af07-4ac0-a525-6dc8c426a204.gif",
            "https://wger.de/media/exercise-images/849/30b2631d-d7ec-415c-800b-7eb082314c0a.gif"
        )
    ),
    Exercise(
        id = 907,
        name = "Handstand Push Up",
        description = "Handstands Push Up which demand high level of skill",
        category = ExerciseCategory(id = 13, name = "Shoulders"),
        images = emptyList()
    ),
    Exercise(
        id = 908,
        name = "Zone 2 Running",
        description = "Zone two Cardio for endurance, you should be able to speak while running",
        category = ExerciseCategory(id = 15, name = "Cardio"),
        images = emptyList()
    ),
    Exercise(
        id = 923,
        name = "LYING DUMBBELL ROW SS SEATED SHRUG",
        description = "laying on the stomach on a bench with slight angle",
        category = ExerciseCategory(id = 12, name = "Back"),
        images = emptyList()
    ),
    Exercise(
        id = 927,
        name = "Suspended crossess",
        description = "Suspension exercise with trx for chest training",
        category = ExerciseCategory(id = 15, name = "Cardio"),
        images = listOf(
            "https://wger.de/media/exercise-images/927/7b392101-9c47-4693-935e-a88b1887eec5.jpg"
        )
    ),
    Exercise(
        id = 958,
        name = "Bicipiti con trx",
        description = "muscoli coinvolti: bicipitiAfferrare le maniglie delle cinghie TRX, " +
            "inclinare il corpo all’indietro.Braccia e gambe distese, corpo disposto " +
            "su un’unica linea.",
        category = ExerciseCategory(id = 10, name = "Abs"),
        images = listOf(
            "https://wger.de/media/exercise-images/958/947ac249-475d-44ed-bed3-8dc433374f59.png",
            "https://wger.de/media/exercise-images/958/95f2bbc4-2f95-476d-a9b8-81b333fe2ef5.png",
            "https://wger.de/media/exercise-images/958/dfad24f7-3f6f-497c-8436-7dfd909bca3f.png"
        )
    ),
    Exercise(
        id = 960,
        name = "kettlebell swing",
        description = "While kettlebell swings are a full-body workout, they mostly target " +
            "the muscles along the posterior chain (back of the body). The main muscles used " +
            "are the glutes, hamstrings, spinal erectors, and muscles of the upper back.",
        category = ExerciseCategory(id = 10, name = "Abs"),
        images = emptyList()
    ),
    Exercise(
        id = 961,
        name = "Swimming 50m sprints",
        description = "50m swimming sprints at 1min",
        category = ExerciseCategory(id = 15, name = "Cardio"),
        images = emptyList()
    ),
    Exercise(
        id = 962,
        name = "Elliptical",
        description = "It improves muscle toning, strengthens the leg muscles " +
            "(quads, glutes, calves), helps vascularisation and increases resistance. " +
            "The elliptical is also very useful if you aim to lose weight.",
        category = ExerciseCategory(id = 15, name = "Cardio"),
        images = emptyList()
    ),
    Exercise(
        id = 975,
        name = "one-handed kettlebell curls",
        description = "Standing with the kettlebell in one hand and bent at the elbow, start " +
            "from a fully extended position until your hand reaches shoulder height. " +
            "To perform the movement correctly, try not to push with your back or body.",
        category = ExerciseCategory(id = 8, name = "Arms"),
        images = emptyList()
    ),
    Exercise(
        id = 976,
        name = "Medicine ball booklet crunch",
        description = "Using a medicine ball as an overload will make the exercise heavier.",
        category = ExerciseCategory(id = 10, name = "Abs"),
        images = emptyList()
    )
)

package com.example.moviecatalogue.utils

import com.example.moviecatalogue.model.Movie

object DataDummy {
    fun getDataMovie(): List<Movie> {
        val movie = ArrayList<Movie>()
        movie.add(
            Movie(
                id = 1,
                original_title = "Godzilla vs. Kong",
                overview = "In a time when monsters walk the Earth, humanity’s fight for its future sets Godzilla and Kong on a collision course that will see the two most powerful forces of nature on the planet collide in a spectacular battle for the ages.",
                poster_path = "/pgqgaUx1cJb5oZQQ5v0tNARCeBp.jpg",
                release_date = "2021-03-24",
                vote_average = 8.3
            )
        )

        movie.add(
            Movie(
                id = 2,
                original_title = "Zack Snyder's Justice League",
                overview = "Determined to ensure Superman's ultimate sacrifice was not in vain, Bruce Wayne aligns forces with Diana Prince with plans to recruit a team of metahumans to protect the world from an approaching threat of catastrophic proportions.",
                poster_path = "/tnAuB8q5vv7Ax9UAEje5Xi4BXik.jpg",
                release_date = "2021-03-18",
                vote_average = 8.5
            )
        )
        movie.add(
            Movie(
                id = 3,
                original_title = "Chaos Walking",
                overview = "Two unlikely companions embark on a perilous adventure through the badlands of an unexplored planet as they try to escape a dangerous and disorienting reality, where all inner thoughts are seen and heard by everyone.",
                poster_path = "/9kg73Mg8WJKlB9Y2SAJzeDKAnuB.jpg",
                release_date = "2021-02-24",
                vote_average = 7.4
            )
        )
        movie.add(
            Movie(
                id = 4,
                original_title = "Mortal Kombat",
                overview = "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe.",
                poster_path = "/8yhtzsbBExY8mUct2GOk4LDDuGH.jpg",
                release_date = "2021-04-07",
                vote_average = 7.4
            )
        )
        movie.add(
            Movie(
                id = 5,
                original_title = "Raya and the Last Dragon",
                overview = "Long ago, in the fantasy world of Kumandra, humans and dragons lived together in harmony. But when an evil force threatened the land, the dragons sacrificed themselves to save humanity. Now, 500 years later, that same evil has returned and it’s up to a lone warrior, Raya, to track down the legendary last dragon to restore the fractured land and its divided people.",
                poster_path = "/lPsD10PP4rgUGiGR4CCXA6iY0QQ.jpg",
                release_date = "2021-03-03",
                vote_average = 8.3
            )
        )

        movie.add(
            Movie(
                id = 6,
                original_title = "Thunder Force",
                overview = "In a world where supervillains are commonplace, two estranged childhood best friends reunite after one devises a treatment that gives them powers to protect their city.",
                poster_path = "/279yOM4OQREL36B3SECnRxoB4MZ.jpg",
                release_date = "2021-04-09",
                vote_average = 5.9
            )
        )
        movie.add(
            Movie(
                id = 7,
                original_title = "Mortal Kombat Legends: Scorpion's Revenge",
                overview = "After the vicious slaughter of his family by stone-cold mercenary Sub-Zero, Hanzo Hasashi is exiled to the torturous Netherrealm. There, in exchange for his servitude to the sinister Quan Chi, he’s given a chance to avenge his family – and is resurrected as Scorpion, a lost soul bent on revenge. Back on Earthrealm, Lord Raiden gathers a team of elite warriors – Shaolin monk Liu Kang, Special Forces officer Sonya Blade and action star Johnny Cage – an unlikely band of heroes with one chance to save humanity. To do this, they must defeat Shang Tsung’s horde of Outworld gladiators and reign over the Mortal Kombat tournament.",
                poster_path = "/4VlXER3FImHeFuUjBShFamhIp9M.jpg",
                release_date = "2020-04-12",
                vote_average = 8.4
            )
        )

        movie.add(
            Movie(
                id = 8,
                original_title = "Monster Hunter",
                overview = "A portal transports Cpt. Artemis and an elite unit of soldiers to a strange world where powerful monsters rule with deadly ferocity. Faced with relentless danger, the team encounters a mysterious hunter who may be their only hope to find a way home.",
                poster_path = "/1UCOF11QCw8kcqvce8LKOO6pimh.jpg",
                release_date = "2020-12-03",
                vote_average = 7.1
            )
        )
        movie.add(
            Movie(
                id = 9,
                original_title = "Twist",
                overview = "A Dicken’s classic brought thrillingly up to date in the teeming heartland of modern London, where a group of street smart young hustlers plan the heist of the century for the ultimate payday.",
                poster_path = "/29dCusd9PwHrbDqzxNG35WcpZpS.jpg",
                release_date = "2021-01-22",
                vote_average = 7.0
            )
        )

        movie.add(
            Movie(
                id = 10,
                original_title = "Sentinelle",
                overview = "Transferred home after a traumatizing combat mission, a highly trained French soldier uses her lethal skills to hunt down the man who hurt her sister.",
                poster_path = "/fFRq98cW9lTo6di2o4lK1qUAWaN.jpg",
                release_date = "2021-03-05",
                vote_average = 6.1
            )
        )
        return movie
    }

    fun getDataTv(): List<Movie> {
        val tv = ArrayList<Movie>()
        tv.add(
            Movie(
                id = 1,
                original_name = "The Falcon and the Winter Soldier",
                overview = "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
                poster_path = "/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                first_air_date = "2021-03-19",
                vote_average = 7.9
            )
        )
        tv.add(
            Movie(
                id = 2,
                original_name = "The Good Doctor",
                overview = "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives.",
                poster_path = "/6tfT03sGp9k4c0J3dypjrI8TSAI.jpg",
                first_air_date = "2017-09-25",
                vote_average = 8.6
            )
        )
        tv.add(
            Movie(
                id = 3,
                original_name = "The Flash",
                overview = "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                poster_path = "/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg",
                first_air_date = "2014-10-07",
                vote_average = 7.7
            )
        )
        tv.add(
            Movie(
                id = 4,
                original_name = "Invincible",
                overview = "Mark Grayson is a normal teenager except for the fact that his father is the most powerful superhero on the planet. Shortly after his seventeenth birthday, Mark begins to develop powers of his own and enters into his father’s tutelage.",
                poster_path = "/yDWJYRAwMNKbIYT8ZB33qy84uzO.jpg",
                first_air_date = "2021-03-26",
                vote_average = 8.9
            )
        )
        tv.add(
            Movie(
                id = 5,
                original_name = "Riverdale",
                overview = "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.",
                poster_path = "/wRbjVBdDo5qHAEOVYoMWpM58FSA.jpg",
                first_air_date = "2017-01-26",
                vote_average = 8.6
            )
        )
        tv.add(
            Movie(
                id = 6,
                original_name = "Grey's Anatomy",
                overview = "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
                poster_path = "/clnyhPqj1SNgpAdeSS6a6fwE6Bo.jpg",
                first_air_date = "2005-03-27",
                vote_average = 8.2
            )
        )
        tv.add(
            Movie(
                id = 7,
                original_name = "Lucifer",
                overview = "Bored and unhappy as the Lord of Hell, Lucifer Morningstar abandoned his throne and retired to Los Angeles, where he has teamed up with LAPD detective Chloe Decker to take down criminals. But the longer he's away from the underworld, the greater the threat that the worst of humanity could escape.",
                poster_path = "/4EYPN5mVIhKLfxGruy7Dy41dTVn.jpg",
                first_air_date = "2016-01-25",
                vote_average = 8.5
            )
        )

        tv.add(
            Movie(
                id = 8,
                original_name = "The Walking Dead",
                overview = "Sheriff's deputy Rick Grimes awakens from a coma to find a post-apocalyptic world dominated by flesh-eating zombies. He sets out to find his family and encounters many other survivors along the way.",
                poster_path = "/rqeYMLryjcawh2JeRpCVUDXYM5b.jpg",
                first_air_date = "2016-01-25",
                vote_average = 8.1
            )
        )
        tv.add(
            Movie(
                id = 9,
                original_name = "WandaVision",
                overview = "Wanda Maximoff and Vision—two super-powered beings living idealized suburban lives—begin to suspect that everything is not as it seems.",
                poster_path = "/glKDfE6btIRcVB5zrjspRIs4r52.jpg",
                first_air_date = "2021-01-15",
                vote_average = 8.4
            )
        )
        tv.add(
            Movie(
                id = 10,
                original_name = "Superman & Lois",
                overview = "After years of facing megalomaniacal supervillains, monsters wreaking havoc on Metropolis, and alien invaders intent on wiping out the human race, The Man of Steel aka Clark Kent and Lois Lane come face to face with one of their greatest challenges ever: dealing with all the stress, pressures and complexities that come with being working parents in today's society.",
                poster_path = "/6SJppowm7cdQgLkvoTlnTUSbjr9.jpg",
                first_air_date = "2021-02-23",
                vote_average = 8.3
            )
        )


        return tv
    }



}
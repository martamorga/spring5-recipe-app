package mmo.app.spring5recipeapp.domain

import javax.persistence.*

@Entity
class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0

    @OneToOne
    var recipe: Recipe = Recipe()

    @Lob
    var recipeNotes: String = ""

}
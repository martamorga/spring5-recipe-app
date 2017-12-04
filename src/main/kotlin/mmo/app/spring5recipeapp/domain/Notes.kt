package mmo.app.spring5recipeapp.domain

import javax.persistence.*

@Entity
class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0

    @Lob
    var recipeNotes: String = ""

    @OneToOne(cascade = arrayOf(CascadeType.ALL))
    var notes: Notes? = null

}
package sv.com.bytews.practicaintellij.data.bo;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private String apellido;

    @Column(name = "edad")
    private Integer edad;

    private String correoElectronico;

    @ManyToOne
    private Telefono telefono;

}
package br.com.alencarsites.usuario;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

import br.com.alencarsites.dtos.UsuarioDTO;
import br.com.alencarsites.responses.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author  Romerito Alencar da Silva
 */


@Validated
@RestController
@RequestMapping("/api/usuario")
@CrossOrigin(origins = "*")
public class UsuarioController {

    private static final Logger LOGGER = LogManager.getLogger(UsuarioController.class);

    private Usuario usuario;

    /**
     * @param usuarioDTO
     * @return ChamadoResponse
     */
    @ApiOperation(value = "Criar usuário")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Usuário criado", response = Usuario.class),
            @ApiResponse(code = 400, message = "Erro ao criar usuário")
    })
    @PostMapping(path = "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> criarUsuario(@RequestBody @Validated UsuarioDTO usuarioDTO) {
        try {
            LOGGER.info("Criando ... Usuário .... Empresa {} " );
         //   listaChamadoDTOs = chamadoService.consultarChamado(usuarioDTO);
          //  chamado.add(linkTo(methodOn((ChamadoController.class)).consultarChamado(usuarioDTO)).withSelfRel());
         //  LOGGER.info("Consultado ... Chamados {} " ,  listaChamadoDTOs);
            return Response.responseBuilder(HttpStatus.OK,  usuario);
        } catch (Exception e) {
            LOGGER.info("Criar Usuário ... {} ... Empresa ");
            LOGGER.info("Error ... {} " , e.getMessage());
            return Response.responseBuilder(HttpStatus.BAD_REQUEST, usuarioDTO);
        }
    }

    @GetMapping("/")
    public String home() {

        return "Hello, Home!";
    }

    @GetMapping("/secured")
    public String secured() {
        return "Hello, Secured!";
    }

}

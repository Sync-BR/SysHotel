package com.sistema.hotel.util.userUtil;

import com.sistema.hotel.model.client.address.dto.AddressDto;
import com.sistema.hotel.model.client.address.entities.AddressEntities;
import com.sistema.hotel.model.client.dto.ClientDto;
import com.sistema.hotel.model.client.dto.UserDto;
import com.sistema.hotel.model.client.entities.ClientEntities;
import com.sistema.hotel.model.client.entities.UserEntities;

import com.sistema.hotel.util.data.abstractClass.UserAbstract;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserUtil extends UserAbstract {

    public UserUtil(PasswordEncoder passwordEncoder) {
        super(passwordEncoder);
    }

    /**
     *  Remover espaçamento dos dados do usuário.
     * @param user Recebe um conjuto de dados do usuário
     * @return Retornar usuário formatado sem espaçamentos!
     */
    protected UserEntities removeSpacing(UserEntities user){
        return new UserEntities(user.getUsername().trim().replaceAll(" ", ""), user.getPassword().trim().replaceAll(" ", ""));
    }

    /**
     * Remover espaçamento do campo email
     * @param email Recebe um string com um valor de email
     * @return retornar esse string formatado
     */
    protected  String removeSpacesEmail(String email){
        return email.replaceAll(" ", "").replaceAll(" ", "");
    }


    /**
     * Converte um dto para uma entidade
     * @param client recebe um conjuto de dados em dto
     * @return retornar o cliente convertido para entidade
     */
    private ClientEntities covertClient(ClientDto client){
        return  new ClientEntities(
                client.getClientName(),
                formatCpf(client.getClientCpf()),
                removeSpacesEmail(client.getClientEmail()),
                formatPhoneNumber(client.getClientPhone()),
                covertAddress(client.getAddress()),
                removeSpacing(covertUser(client.getClientUser()))
        );
    }

    /**
     * Converte um dto para uma entidade
     * @param client recebe um conjuto de dados em dto
     * @return retornar o cliente convertido para entidade
     */
    private ClientDto covertDtoClient(ClientEntities client){
        return  new ClientDto(
                client.getName(),
                formatCpf(client.getCpf()),
                removeSpacesEmail(client.getEmail()),
                formatPhoneNumber(client.getPhone()),
                covertAddress(client.getAddress()),
                covertUserDto(client.getDateUser())
        );
    }

    /**
     * Converte um dto para entidade
     * @param address receber um objeto do tipo endereço dtoo
     * @return retornar o dto convertido para entidade
     */
    private AddressEntities covertAddress(AddressDto address){
        return new AddressEntities(
                address.getClientStreet(),
                address.getClientComplement(),
                address.getClientNeighborhood(),
                address.getClientLocality(),
                address.getClientState(),
                address.getClientPostalCode()
        );

    }
    /**
     * Converte uma entidade para Dto
     * @param address receber um objeto do tipo endereço dtoo
     * @return retornar o entidade convertido para dto
     */
    private AddressDto covertAddress(AddressEntities address){
        return new AddressDto(
                address.getStreet(),
                address.getComplement(),
                address.getNeighborhood(),
                address.getLocality(),
                address.getState(),
                address.getPostalCode()
        );

    }
    /**
     * Converte um dto para entidade
     * @param user receber um objeto do tipo user dtoo
     * @return retornar o dto convertido para entidade
     */
    protected UserEntities covertUser(UserDto user){
        return new UserEntities(user.getUsername(), encryptPassword(user.getPassword()));
    }
    /**
     * Converte uma entidade para dto
     * @param user receber um objeto do tipo user entidade
     * @return retornar o dto convertido para dto
     */
    protected UserDto covertUserDto(UserEntities user){
        return new UserDto(user.getUsername(), encryptPassword(user.getPassword()));
    }
    /**
     *
     * Converte um objeto em entidade
     * @param dto receber os dados em dto do tipo cliente
     * @return retornar o objeto convertido em entidade
     */
    protected ClientEntities convertDtoToEntities(ClientDto dto) {
        return covertClient(dto);

    }
    protected ClientDto convertEntitiesToDto(ClientEntities entities) {
        return covertDtoClient(entities);
    }



}

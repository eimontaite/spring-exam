package lt.itakademija.controller;

import lt.itakademija.model.Id;
import lt.itakademija.model.command.CreateContact;
import lt.itakademija.model.command.CreateMessage;
import lt.itakademija.model.command.UpdateContact;
import lt.itakademija.model.query.Contact;
import lt.itakademija.model.query.Message;
import lt.itakademija.repository.MessengerRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mariusg on 2017.03.19.
 */
@RestController
@RequestMapping(value = "/")
//@Api(value = "Messenger Controller")
public class MessengerServiceController {

	@Autowired
	private final MessengerRepository repository;

	public MessengerServiceController(@Valid @RequestBody MessengerRepository repository) {
		this.repository = repository;
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
//	@ApiOperation(value = "Creates contact")
	public Long createContact(@Valid @RequestBody CreateContact createContact) {
		return repository.createContact(createContact);
	}

	@RequestMapping(method = RequestMethod.GET, value = "webapi/messenger/contacts")
	@ResponseStatus(HttpStatus.OK)
//	@ApiOperation(value = "Gets all contacts")
	public List<Contact> getContacts() {
		return repository.getContacts();
	}

	@RequestMapping(method = RequestMethod.GET, value = "webapi/messenger/contacts/{contactId}")
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Gets a contact by ID")
	public Contact getContact(@PathVariable Long contactId) {
		return repository.getContact(contactId);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "webapi/messenger/contacts/{contactId}")
	@ResponseStatus(HttpStatus.OK)
//	@ApiOperation(value = "Updates a specific contact")
	public void updateContact(@PathVariable Long contactId, @Valid @RequestBody UpdateContact updateContact) {
		repository.updateContact(contactId, updateContact);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "webapi/messenger/contacts/{contactId}")
	@ResponseStatus(HttpStatus.OK)
//	@ApiOperation(value = "Deletes contact by ID", notes = "Returns deleted contact")
	public void deleteContact(@PathVariable Long contactId) {
		repository.deleteContact(contactId);
	}

	@RequestMapping(method = RequestMethod.POST, value = "webapi/messenger/messages/{contactId}")
	@ResponseStatus(HttpStatus.CREATED)
//	@ApiOperation(value = "Create message")
	public Long createMessage(@PathVariable Long contactId, @RequestBody CreateMessage createMessage) {
		return repository.createMessage(contactId, createMessage);
	}

	@RequestMapping(method = RequestMethod.GET, value = "webapi/messenger/messages/{contactId}")
	@ResponseStatus(HttpStatus.OK)
//	@ApiOperation(value = "Get messages")
	public List<Message> getMessages(@PathVariable Long contactId) {
		return repository.getMessages(contactId);
	}

}
